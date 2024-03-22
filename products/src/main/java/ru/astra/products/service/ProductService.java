package ru.astra.products.service;

import ru.astra.products.entity.Product;
import ru.astra.products.domain.ProductRequest;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);
    List<Product> findAllByUserId(String userId);

    List<Product> findAll();

    Product save(ProductRequest request);

    Product update(Long id, ProductRequest product);

    void removeById(Long id);

    Optional<Product> findByIdAndUserId(Long id, String userId);
}
