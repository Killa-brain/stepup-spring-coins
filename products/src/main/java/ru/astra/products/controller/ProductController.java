package ru.astra.products.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import ru.astra.products.domain.ProductRequest;
import ru.astra.products.domain.ProductResponse;
import ru.astra.products.dtos.PageDto;
import ru.astra.products.service.ProductService;
import ru.astra.products.utils.Mapper;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public PageDto<ProductResponse> getListProducts() {
        return new PageDto<>(Mapper.mapListResponse(productService.findAll()));
    }

    @GetMapping("/user")
    public PageDto<ProductResponse> getListByUser(@RequestHeader(name = "USERID") String userId) {
        return new PageDto<>(Mapper.mapListResponse(productService.findAllByUserId(userId)));
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable("id") Long id, @RequestHeader(name = "USERID") String userId) {
        var product = productService.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new IllegalArgumentException("Cannot found product by id: " + id));
        return Mapper.mapToResponse(product);
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest request) {
        return Mapper.mapToResponse(productService.save(request));
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long id,
                                         @RequestBody ProductRequest request) {
        return Mapper.mapToResponse(productService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public List<ProductResponse> deleteById(@PathVariable("id") Long id) {
        productService.removeById(id);
        return Mapper.mapListResponse(productService.findAll());
    }
}
