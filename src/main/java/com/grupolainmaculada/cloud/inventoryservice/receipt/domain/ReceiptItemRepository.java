package com.grupolainmaculada.cloud.inventoryservice.receipt.domain;

import org.springframework.data.repository.CrudRepository;

public interface ReceiptItemRepository extends CrudRepository<ReceiptItem, ReceiptItemId> {
}
