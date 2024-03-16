package ru.stepup.spring.coins.core.integrations;

import ru.stepup.spring.coins.core.api.ProductRequest;
import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.dtos.PageDto;

public interface ProductIntegration {
    PageDto<ProductResponse> getProducts(ProductRequest productRequest);

    PageDto<ProductResponse> getAllProducts();
}
