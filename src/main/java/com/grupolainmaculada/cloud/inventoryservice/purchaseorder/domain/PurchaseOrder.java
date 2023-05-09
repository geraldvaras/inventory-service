package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain;

import com.grupolainmaculada.cloud.inventoryservice.common.domain.SupplierInfo;
import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.HashSet;
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

    @Column(name = "NUMITEM")
    private Integer itemNumber;

    @Column(name = "NOTAS")
    private String notes;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "internalCode", column = @Column(name = "CODPROV")),
            @AttributeOverride(name = "comercialName", column = @Column(name = "COMPANIA")),
            @AttributeOverride(name = "documentNumber", column = @Column(name = "RUC")),
            @AttributeOverride(name = "address", column = @Column(name = "DIRECCION"))
    })
    private SupplierInfo supplierInfo;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @LastModifiedDate
    @Column(name = "UPDATEFECHAHORA")
    private Instant lastModifiedDate;

    @Column(name = "FECHEMISION")
    private Instant issueDate;
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

    private void setItems(Set<PurchaseOrderItem> items) {
        this.items = items;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    private void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getNotes() {
        return notes;
    }

    private void setNotes(String notes) {
        this.notes = notes;
    }

    public SupplierInfo getSupplierInfo() {
        return supplierInfo;
    }

    private void setSupplierInfo(SupplierInfo supplierInfo) {
        this.supplierInfo = supplierInfo;
    }

    public Instant getIssueDate() {
        return issueDate;
    }

    private void setIssueDate(Instant issueDate) {
        this.issueDate = issueDate;
    }
}
