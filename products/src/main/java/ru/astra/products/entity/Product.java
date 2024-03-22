package ru.astra.products.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.astra.products.domain.ProductType;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "account_number")
    private Integer accountNumber;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    public Product() {
    }

    public Product(Long id, Long userId, Integer accountNumber, BigDecimal balance, ProductType productType) {
        this.id = id;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = productType;
    }

    public Product(Long userId, Integer accountNumber, BigDecimal balance, ProductType productType) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.productType = productType;
    }
}
