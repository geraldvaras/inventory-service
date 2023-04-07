package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record Product(
        @Valid
        ProductId id,

        @NotBlank(
                message = "The description must be defined."
        )
        String description,
        @NotNull(message = "The unit price must be defined.")
        @Positive(
                message = "The unit price must be greater than zero."
        )
        BigDecimal unitPrice,

        @NotNull(message = "The unit cost must be defined.")
        @Positive(
                message = "The unit cost must be greater than zero."
        )
        BigDecimal unitCost
) {
}
