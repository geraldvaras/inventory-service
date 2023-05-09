package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.dto;

import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain.PurchaseOrder;
import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain.PurchaseOrderItem;

import java.time.Instant;

public record PurchaseOrderItemDto
        (String internalCode, String description, String presentation, Integer fraction,
         Integer integerQuantity, Integer fractionaQuantity, Integer bonusQuantity, Integer totalQuantity) {

    public static PurchaseOrderItemDto fromEntity(PurchaseOrderItem item) {
        return new PurchaseOrderItemDto(
                item.getProductInfo().getInternalCode(),
                item.getProductInfo().getDescription(),
                item.getProductInfo().getPresentation(),
                item.getFraction().getFraction(),
                item.getQuantity().getInteger(),
                item.getQuantity().getFractional(),
                item.getQuantity().getBonus(),
                item.getQuantity().getTotal()
        );
    }
}
