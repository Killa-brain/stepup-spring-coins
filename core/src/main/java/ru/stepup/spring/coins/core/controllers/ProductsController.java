package ru.stepup.spring.coins.core.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.dtos.PageDto;
import ru.stepup.spring.coins.core.services.ProductService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductsController {
    private final ProductService productService;

    @GetMapping
    PageDto<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}
