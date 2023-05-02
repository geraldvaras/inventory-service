package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "OCOMCAB")
public class PurchaseOrder {

    @EmbeddedId
    private PurchaseOrderId purchaseOrderId;

    @OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PurchaseOrderItem> items = new HashSet<>();

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @LastModifiedDate
    @Column(name = "UPDATEFECHAHORA")
    private Instant lastModifiedDate;

    public void addPurchaseDetail(PurchaseOrderItem orderDetail) {
        if (Objects.isNull(orderDetail)) {
            items = new HashSet<>();
        }
        items.add(orderDetail);
    }

    public PurchaseOrder() {
    }

    private PurchaseOrder(PurchaseOrderId purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public static PurchaseOrder of(PurchaseOrderId id) {
        return new PurchaseOrder(id);
    }

    public PurchaseOrderId getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(PurchaseOrderId purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<PurchaseOrderItem> getItems() {
        return items;
    }

    public void setItems(Set<PurchaseOrderItem> items) {
        this.items = items;
    }
}
