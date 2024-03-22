package ru.stepup.spring.coins.core.services;

import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.dtos.PageDto;

public interface ProductService {
    PageDto<ProductResponse> getProductsByUser(String userId);

    PageDto<ProductResponse> getAllProducts();
}
