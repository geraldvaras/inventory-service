package com.grupolainmaculada.cloud.inventoryservice.receipt.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReceiptPurchaseOrderId implements Serializable {

    @Column(name = "CODEMP")
    private String organizationId;

    @Column(name = "CODSUC")
    private String branchId;

    @Column(name = "CODALM")
    private String warehouseId;

    @Column(name = "IDRECEPCION")
    private Long receiptId;

    @Column(name = "IDORDENCOMPRA")
    private String purchaseOrderId;

    public static ReceiptPurchaseOrderId of(
            String organizationId, String branchId, String warehouseId, Long receiptId, String purchaseOrderId) {
        return new ReceiptPurchaseOrderId(organizationId, branchId, warehouseId,
                receiptId, purchaseOrderId);
    }

    private ReceiptPurchaseOrderId(
            String organizationId, String branchId, String warehouseId, Long receiptId, String purchaseOrderId) {
        this.organizationId = organizationId;
        this.branchId = branchId;
        this.warehouseId = warehouseId;
        this.receiptId = receiptId;
        this.purchaseOrderId = purchaseOrderId;
    }

    public ReceiptPurchaseOrderId() {}

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

    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptPurchaseOrderId that = (ReceiptPurchaseOrderId) o;
        return Objects.equals(organizationId, that.organizationId) && Objects.equals(branchId, that.branchId) && Objects.equals(warehouseId, that.warehouseId) && Objects.equals(receiptId, that.receiptId) && Objects.equals(purchaseOrderId, that.purchaseOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationId, branchId, warehouseId, receiptId, purchaseOrderId);
    }
}
