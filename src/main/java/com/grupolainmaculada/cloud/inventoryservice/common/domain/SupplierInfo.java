package com.grupolainmaculada.cloud.inventoryservice.common.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class SupplierInfo {

    private String internalCode;

    private String documentNumber;

    private String comercialName;

    private String address;

    public SupplierInfo() {
    }

    public String getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(String internalCode) {
        this.internalCode = internalCode;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    private void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public String getComercialName() {
        return comercialName;
    }

    private void setComercialName(String comercialName) {
        this.comercialName = comercialName;
    }
}
