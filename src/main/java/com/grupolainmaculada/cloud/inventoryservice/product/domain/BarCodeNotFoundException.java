package com.grupolainmaculada.cloud.inventoryservice.product.domain;

public class BarCodeNotFoundException extends RuntimeException{
    public BarCodeNotFoundException(String barCode) {
        super("The product with code barcode " + barCode + " was not found.");
    }
}
