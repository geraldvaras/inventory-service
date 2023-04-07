package com.grupolainmaculada.cloud.inventoryservice.product.domain;

public class ProductAlreadyExistsException extends RuntimeException {
    public ProductAlreadyExistsException(ProductId id) {
        super("The product with code " + id.code() + " already exists.");
    }
}
