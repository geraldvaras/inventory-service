package com.grupolainmaculada.cloud.inventoryservice.common.domain;

public class FractionNegativeException extends RuntimeException {

    public FractionNegativeException(Integer fraction) {
        super("The fraction "+ fraction + " has invalid value.");
    }
}
