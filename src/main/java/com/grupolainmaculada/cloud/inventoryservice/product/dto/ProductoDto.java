package com.grupolainmaculada.cloud.inventoryservice.product.dto;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.Product;

public record ProductoDto(String producId, String description, Integer fraction) {

    public static ProductoDto fromEntity(Product product) {
        return new ProductoDto(product.getId().getCode(), product.getDescription(),
                product.getFraction().getFraction());
    }
}
