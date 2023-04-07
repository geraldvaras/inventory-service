package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProductId(
        @NotBlank(message = "The organization id must be defined.")
        String organizationId,

        @NotBlank(message = "The branch id must be defined.")
        String branchId,
        @NotBlank(message = "The product code must be defined.")
        @Pattern(
                regexp = "^([0-9]{8})$",
                message = "The product code format must be valid."
        )
        String code) {

    public static ProductId of(String organizationId, String branchId, String code) {
        return new ProductId(organizationId, branchId, code);
    }
}
