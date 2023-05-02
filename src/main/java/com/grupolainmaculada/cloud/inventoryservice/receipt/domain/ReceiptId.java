package com.grupolainmaculada.cloud.inventoryservice.receipt.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ReceiptId implements Serializable {

    @Column(name = "CODEMP")
    private String organizationId;

    @Column(name = "CODSUC")
    private String branchId;

    @Column(name = "CODALM")
    private String warehouseId;

    @Column(name = "INTERNO")
    private Long code;

    public static ReceiptId of(String organizationId, String branchId, String warehouseId, Long code) {
        return new ReceiptId(organizationId, branchId, warehouseId, code);
    }

    private ReceiptId(String organizationId, String branchId, String warehouseId, Long code) {
        this.organizationId = organizationId;
        this.branchId = branchId;
        this.warehouseId = warehouseId;
        this.code = code;
    }

    public ReceiptId() {}

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

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptId receiptId = (ReceiptId) o;

        if (!organizationId.equals(receiptId.organizationId)) return false;
        if (!branchId.equals(receiptId.branchId)) return false;
        if (!warehouseId.equals(receiptId.warehouseId)) return false;
        return code.equals(receiptId.code);
    }

    @Override
    public int hashCode() {
        int result = organizationId.hashCode();
        result = 31 * result + branchId.hashCode();
        result = 31 * result + warehouseId.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }
}
