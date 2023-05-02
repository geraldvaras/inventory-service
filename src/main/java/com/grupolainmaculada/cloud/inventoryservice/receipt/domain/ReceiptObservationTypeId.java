package com.grupolainmaculada.cloud.inventoryservice.receipt.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReceiptObservationTypeId implements Serializable {

    @Column(name = "CODEMP")
    private String organizationId;

    @Column(name = "IDTIPOOBSERVACION")
    private Integer code;

    public  ReceiptObservationTypeId(){}

    private  ReceiptObservationTypeId(String organizationId, Integer code) {
        this.organizationId = organizationId;
        this.code = code;
    }

    public static ReceiptObservationTypeId of(String organizationId, Integer code) {
        return new ReceiptObservationTypeId(organizationId, code);
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptObservationTypeId that = (ReceiptObservationTypeId) o;
        return Objects.equals(organizationId, that.organizationId) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, code);
    }
}
