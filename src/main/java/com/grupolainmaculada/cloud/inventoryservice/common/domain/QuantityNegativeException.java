package com.grupolainmaculada.cloud.inventoryservice.common.domain;

public class QuantityNegativeException extends RuntimeException {

    public QuantityNegativeException(PartNumber part, Integer quantity) {
        super("The "+ part.name() + " part " + quantity + " is an invalid value, it should be greater than zero.");
    }
}
