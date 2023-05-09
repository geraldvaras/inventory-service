package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BarCodeId implements Serializable {

    @Embedded
    private ProductId productId;

    @Column(name = "CODBAR")
    private String barCode;

    private BarCodeId(ProductId productId, String barCode) {
        this.productId = productId;
        this.barCode = barCode;
    }

    public BarCodeId() {
    }

    public static BarCodeId of(ProductId productId, String barCode) {
        return new BarCodeId(productId, barCode);
    }

    public ProductId getProductId() {
        return productId;
    }

    private void setProductId(ProductId productId) {
        this.productId = productId;
    }

    public String getBarCode() {
        return barCode;
    }

    private void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BarCodeId barCodeId = (BarCodeId) o;

        if (!Objects.equals(productId, barCodeId.productId)) return false;
        return Objects.equals(barCode, barCodeId.barCode);
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (barCode != null ? barCode.hashCode() : 0);
        return result;
    }
}
