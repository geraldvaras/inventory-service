package com.grupolainmaculada.cloud.inventoryservice.receipt.domain;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "RECEPCIONORDENCOMPRA")
public class ReceiptPurchaseOrder {

    @EmbeddedId
    private ReceiptPurchaseOrderId receiptPurchaseOrderId;

    @Column(name = "FECHAREGISTRO")
    private LocalDateTime registerDate;

    public ReceiptPurchaseOrder() {
    }

    private ReceiptPurchaseOrder(ReceiptPurchaseOrderId receiptPurchaseOrderId) {
        this.receiptPurchaseOrderId = receiptPurchaseOrderId;
    }

    public ReceiptPurchaseOrderId getReceiptPurchaseOrderId() {
        return receiptPurchaseOrderId;
    }

    private void setReceiptPurchaseOrderId(ReceiptPurchaseOrderId receiptPurchaseOrderId) {
        this.receiptPurchaseOrderId = receiptPurchaseOrderId;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    private void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }
}
