package com.grupolainmaculada.cloud.inventoryservice.common.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Fraction {

    private Integer fraction;

    public Fraction() {
    }

    private Fraction(Integer fraction) {
        this.fraction = fraction;
    }

    public static Fraction of(Integer fraction) {
        if (fraction < 0) {
            throw new FractionNegativeException(fraction);
        }
        return new Fraction(fraction);
    }

    public Integer getFraction() {
        return fraction;
    }

    private void setFraction(Integer fraction) {
        this.fraction = fraction;
    }
}
