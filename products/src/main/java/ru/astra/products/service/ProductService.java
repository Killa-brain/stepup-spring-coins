package ru.astra.products.service;

import ru.astra.products.entity.Product;
import ru.astra.products.domain.ProductRequest;

import java.util.List;

public interface ProductService {

    Product findById(Long id);
    List<Product> findAllByUserId(Long userId);

    List<Product> findAll();

    Product save(ProductRequest request);

    Product update(Long id, ProductRequest product);

    boolean removeById(Long id);
}
