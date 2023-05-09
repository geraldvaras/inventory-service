package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseOrderRepository
        extends CrudRepository<PurchaseOrder, PurchaseOrderId> {

    @Query("""
            select po from PurchaseOrder po 
            where po.purchaseOrderId.organizationId = ?1 and po.purchaseOrderId.branchId = ?2 
            and po.supplierInfo.documentNumber = ?3
            order by po.issueDate desc
            """)
    Page<PurchaseOrder> findBySupplierId(
            String organizationId, String branchId, String supplierId, Pageable pageable);
}
