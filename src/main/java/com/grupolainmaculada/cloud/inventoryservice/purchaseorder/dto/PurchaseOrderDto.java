package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.dto;

import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain.PurchaseOrder;

import java.time.Instant;

public record PurchaseOrderDto
        (String documentNumber, String comercialName, Integer itemNumber, Instant issueDate) {

    public static PurchaseOrderDto fromEntity(PurchaseOrder purchaseOrder){
        return new PurchaseOrderDto(
                purchaseOrder.getSupplierInfo().getDocumentNumber(),
                purchaseOrder.getSupplierInfo().getComercialName(),
                purchaseOrder.getItemNumber(),
                purchaseOrder.getIssueDate()
                );
    }
}
