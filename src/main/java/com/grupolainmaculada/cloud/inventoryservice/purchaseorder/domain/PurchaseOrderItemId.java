package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseOrderItemId implements Serializable {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "organizationId", column = @Column(name = "CODEMP")),
            @AttributeOverride(name = "branchId", column = @Column(name = "CODSUC")),
            @AttributeOverride(name = "purchaseOrderNumber", column = @Column(name = "NUMORDENCOM"))
    })
    private PurchaseOrderId purchaseOrderId;

    @Column(name = "CODREG")
    private Integer item;

    public PurchaseOrderItemId() {
    }

    private PurchaseOrderItemId(PurchaseOrderId purchaseOrderId, Integer item) {
        this.purchaseOrderId = purchaseOrderId;
        this.item = item;
    }

    public static PurchaseOrderItemId of(PurchaseOrderId id, Integer item) {
        return new PurchaseOrderItemId(id, item);
    }

    public PurchaseOrderId getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(PurchaseOrderId id) {
        this.purchaseOrderId = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseOrderItemId that = (PurchaseOrderItemId) o;

        if (!Objects.equals(purchaseOrderId, that.purchaseOrderId))
            return false;
        return Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        int result = purchaseOrderId != null ? purchaseOrderId.hashCode() : 0;
        result = 31 * result + (item != null ? item.hashCode() : 0);
        return result;
    }
}
