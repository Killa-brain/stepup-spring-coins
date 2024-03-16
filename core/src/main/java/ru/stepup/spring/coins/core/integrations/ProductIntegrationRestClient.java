package ru.stepup.spring.coins.core.integrations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import ru.stepup.spring.coins.core.api.ProductRequest;
import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.dtos.PageDto;
import ru.stepup.spring.coins.core.exceptions.IntegrationException;

public class ProductIntegrationRestClient implements ProductIntegration {
    private final RestClient restClient;

    private static final Logger logger = LoggerFactory.getLogger(ExecutorIntegrationRestTemplate.class.getName());

    public ProductIntegrationRestClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public PageDto<ProductResponse> getProducts(ProductRequest productRequest) {
        try {
            var response = restClient.get()
                    .uri("/api/v1/product/user/" + productRequest.getUserId())
                    .header("Accept", "application/json")
                    .retrieve()
                    .body(new ParameterizedTypeReference<PageDto<ProductResponse>>() {
                    });

            logger.info("response: {}", response);
            return response;
        } catch (IntegrationException e) {
            logger.info("error body: {}", e.getIntegrationErrorDto());
            return null;
        }
    }

    @Override
    public PageDto<ProductResponse> getAllProducts() {
        try {
            var response = restClient.get()
                    .uri("/api/v1/product")
                    .header("Accept", "application/json")
                    .retrieve()
                    .body(new ParameterizedTypeReference<PageDto<ProductResponse>>() {
                    });
            logger.info("response: {}", response);
            return response;
        } catch (IntegrationException e) {
            logger.info("error body: {}", e.getIntegrationErrorDto());
            return null;
        }
    }
}
