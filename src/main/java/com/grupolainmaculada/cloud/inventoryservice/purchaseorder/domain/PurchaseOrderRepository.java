package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain;

import org.springframework.data.repository.CrudRepository;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, PurchaseOrderId> {
}
