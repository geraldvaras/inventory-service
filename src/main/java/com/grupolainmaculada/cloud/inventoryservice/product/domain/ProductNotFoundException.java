package com.grupolainmaculada.cloud.inventoryservice.product.domain;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(ProductId id) {
        super("The product with code " + id.code() + " was not found.");
    }
}
