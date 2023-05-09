package com.grupolainmaculada.cloud.inventoryservice.common.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProductInfo {

    private String internalCode;
    private String description;
    private String presentation;
    private String barCode;

    private ProductInfo(String internalCode, String description, String presentation, String barCode) {
        this.internalCode = internalCode;
        this.description = description;
        this.presentation = presentation;
        this.barCode = barCode;
    }

    public ProductInfo(){
    }

    public static ProductInfo of(String internalCode, String description, String presentation, String barCode) {
        return new ProductInfo(internalCode, description, presentation, barCode);
    }

    public String getInternalCode() {
        return internalCode;
    }

    private void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public String getPresentation() {
        return presentation;
    }

    private void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getBarCode() {
        return barCode;
    }

    private void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
