package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseOrderId implements Serializable {

    @Column(name = "CODEMP")
    private String organizationId;

    @Column(name = "CODSUC")
    private String branchId;

    @Column(name = "NUMORDENCOM")
    private String purchaseOrderNumber;

    public PurchaseOrderId(){}

    private PurchaseOrderId(String organizationId, String branchId, String purchaseOrderNumber) {
        this.organizationId = organizationId;
        this.branchId = branchId;
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public static PurchaseOrderId of(String organizationId, String branchId, String purchaseOrderNumber) {
        return new PurchaseOrderId(organizationId, branchId, purchaseOrderNumber);
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseOrderId that = (PurchaseOrderId) o;

        if (!Objects.equals(organizationId, that.organizationId))
            return false;
        if (!Objects.equals(branchId, that.branchId)) return false;
        return Objects.equals(purchaseOrderNumber, that.purchaseOrderNumber);
    }

    @Override
    public int hashCode() {
        int result = organizationId != null ? organizationId.hashCode() : 0;
        result = 31 * result + (branchId != null ? branchId.hashCode() : 0);
        result = 31 * result + (purchaseOrderNumber != null ? purchaseOrderNumber.hashCode() : 0);
        return result;
    }
}