package ru.stepup.spring.coins.core.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.core.api.ExecuteCoinsRequest;
import ru.stepup.spring.coins.core.api.ExecuteCoinsResponse;
import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.configurations.properties.CoreProperties;
import ru.stepup.spring.coins.core.exceptions.BadRequestException;
import ru.stepup.spring.coins.core.exceptions.IntegrationErrorDto;
import ru.stepup.spring.coins.core.exceptions.IntegrationException;
import ru.stepup.spring.coins.core.integrations.dtos.ProductExecuteRs;
import ru.stepup.spring.coins.core.services.CoinsService;
import ru.stepup.spring.coins.core.services.ProductService;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoinsServiceImpl implements CoinsService {
    private final CoreProperties coreProperties;
    private final ExecutorService executorService;
    private final ProductService productService;

    @Override
    public ExecuteCoinsResponse execute(ExecuteCoinsRequest request) {
        if (coreProperties.getNumbersBlockingEnabled()) {
            if (coreProperties.getBlockedNumbers().contains(request.number())) {
                throw new BadRequestException("Указан заблокированный номер кошелька", "BLOCKED_ACCOUNT_NUMBER");
            }
        }
        getAndCheckProduct(request);
        return executorService.execute(request);
    }

    private void getAndCheckProduct(ExecuteCoinsRequest request) {
        var productPage = productService.getProductsByUser(request.userId());
        if (productPage == null || productPage.getContent() == null || productPage.getContent().isEmpty()) {
            throw new IntegrationException("Products not found for userId: " + request.userId(),
                    new IntegrationErrorDto("404", "Products not found"));
        }

        Optional<ProductResponse> matchingProduct = productPage.getContent().stream()
                .filter(p -> Objects.equals(request.productType(), p.getProductType()))
                .findFirst();

        if (matchingProduct.isPresent()) {
            ProductResponse product = matchingProduct.get();
            if (request.cost().compareTo(product.getBalance()) > 0) {
                throw new BadRequestException("Insufficient funds for the product", "400");
            }

            log.info("The product is available with sufficient funds");
        } else {
            throw new BadRequestException("Product with type: " + request.productType() + " not found", "400");
        }
    }
}
