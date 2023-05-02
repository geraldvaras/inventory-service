package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PurchaseOrderItemRepository extends CrudRepository<PurchaseOrderItem, PurchaseOrderItemId> {

    Set<PurchaseOrderItem> findAllByPurchaseOrder(PurchaseOrder purchaseOrder);
}
