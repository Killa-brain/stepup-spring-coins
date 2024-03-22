package ru.stepup.spring.coins.core.integrations.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductExecuteRs {
    private Integer accountNumber;
    private BigDecimal balance;
    private String productType;
}
