package com.grupolainmaculada.cloud.inventoryservice.common.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class Quantity {

    private Integer integer;

    private Integer fractional;

    private Integer total;

    private Integer bonus;

    public Quantity() {

    }

    private Quantity(Integer integer, Integer fractional, Integer total, Integer bonus) {
        this.integer = integer;
        this.fractional = fractional;
        this.total = total;
        this.bonus = bonus;
    }

    public static Quantity of(Integer integer, Integer fractional, Integer bonus, Fraction fraction) {
        if (integer <= 0) {
            throw new QuantityNegativeException(PartNumber.INTEGER, integer);
        }

        if (fractional <= 0) {
            throw new QuantityNegativeException(PartNumber.FRACTIONAL, fractional);
        }

        if (fraction.getFraction() <= 0) {
            throw new FractionNegativeException(fraction.getFraction());
        }

        Integer total = integer * fraction.getFraction() + fractional + bonus;
        return new Quantity(integer, fractional, total, bonus);
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Integer getFractional() {
        return fractional;
    }

    public void setFractional(Integer fractional) {
        this.fractional = fractional;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
