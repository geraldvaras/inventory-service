package com.grupolainmaculada.cloud.inventoryservice.receipt.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReceiptItemId implements Serializable {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "organizationId", column = @Column(name = "CODEMP")),
            @AttributeOverride(name = "branchId", column = @Column(name = "CODSUC")),
            @AttributeOverride(name = "warehouseId", column = @Column(name = "CODALM")),
            @AttributeOverride(name = "code", column = @Column(name = "INTERNO"))
    })
    private ReceiptId receiptId;

    @Column(name = "ITEM")
    private Long item;

    public ReceiptItemId() {
    }

    private ReceiptItemId(ReceiptId receiptId, Long item) {
        this.receiptId = receiptId;
        this.item = item;
    }

    public static ReceiptItemId of(ReceiptId receiptId, Long item) {
        return new ReceiptItemId(receiptId, item);
    }

    public ReceiptId getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(ReceiptId receiptId) {
        this.receiptId = receiptId;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptItemId that = (ReceiptItemId) o;
        return Objects.equals(receiptId, that.receiptId) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, item);
    }
}
