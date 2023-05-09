package com.grupolainmaculada.cloud.inventoryservice.receipt.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface ReceiptRepository extends CrudRepository<Receipt, ReceiptId> {

    Page<Receipt> findBy
}
