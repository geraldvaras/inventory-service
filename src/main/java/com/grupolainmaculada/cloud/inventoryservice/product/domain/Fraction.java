package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import jakarta.persistence.Column;

public class Fraction {

    @Column(name = "FRACCIONES")
    private Integer fraction;

    public Fraction(){}

    private Fraction(Integer fraction) {
        this.fraction = fraction;
    }

    public static Fraction of(Integer fraction) {
        return new Fraction(fraction);
    }

    public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }
}
