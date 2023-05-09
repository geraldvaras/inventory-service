package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseOrderItemRepository
        extends CrudRepository<PurchaseOrderItem, PurchaseOrderItemId> {

    Page<PurchaseOrderItem> findByPurchaseOrderPurchaseOrderIdOrderByPurchaseOrderItemIdItem
            (PurchaseOrderId purchaseOrderId, Pageable pageable);
}
