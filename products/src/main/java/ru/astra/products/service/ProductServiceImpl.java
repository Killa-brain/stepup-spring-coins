package ru.astra.products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.astra.products.entity.Product;
import ru.astra.products.domain.ProductRequest;
import ru.astra.products.domain.ProductType;
import ru.astra.products.repository.ProductRepository;
import ru.astra.products.utils.Mapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllByUserId(String userId) {
        return productRepository.findAllByUserId(Long.valueOf(userId));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(ProductRequest request) {
        validate(request);
        return productRepository.save(Mapper.requestToEntity(request));
    }

    @Override
    public Product update(Long id, ProductRequest request) {
        validate(request);
        var product = new Product(id,
                request.getUserId(),
                request.getAccountNumber(),
                request.getBalance(),
                ProductType.getByValue(request.getProductType()));
        return productRepository.save(product);
    }

    @Override
    public void removeById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findByIdAndUserId(Long id, String userId) {
        return productRepository.findProductByIdAndUserId(id, Long.valueOf(userId));
    }

    private void validate(ProductRequest request) {
        if (request.getUserId() == null) {
            throw new IllegalArgumentException("userId mustn't be null");
        }
        if (request.getProductType() == null || checkType(request.getProductType())) {
            throw new IllegalArgumentException("productType must be equal card or account");
        }
    }

    private boolean checkType(String productType) {
        return Arrays.stream(ProductType.values())
                .noneMatch(p -> p.getValue().equals(productType));
    }
}
