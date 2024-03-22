package ru.stepup.spring.coins.core.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.core.api.ProductRequest;
import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.dtos.PageDto;
import ru.stepup.spring.coins.core.integrations.ProductIntegration;
import ru.stepup.spring.coins.core.services.ProductService;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductIntegration productIntegration;

    @Override
    public PageDto<ProductResponse> getProductsByUser(String userId) {
        return productIntegration.getProducts(new ProductRequest(userId));
    }

    @Override
    public PageDto<ProductResponse> getAllProducts() {
        return productIntegration.getAllProducts();
    }
}
