package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.service;

import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain.PurchaseOrderId;
import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain.PurchaseOrderItemRepository;
import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain.PurchaseOrderRepository;
import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.dto.PurchaseOrderDto;
import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.dto.PurchaseOrderItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;

    private final PurchaseOrderItemRepository purchaseOrderItemRepository;

    public PurchaseOrderService(
            PurchaseOrderRepository purchaseOrderRepository,
            PurchaseOrderItemRepository purchaseOrderItemRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.purchaseOrderItemRepository = purchaseOrderItemRepository;
    }

    public Page<PurchaseOrderDto> getPurchaseOrdersBySupplierId(
            String organizationId, String branchId, String supplierId,
            int pageNumber, int pageSize) {
        var pageable = PageRequest.of(pageNumber - 1, pageSize);
        var purchases = purchaseOrderRepository
                .findBySupplierId(organizationId, branchId, supplierId, pageable);
        return purchases.map(PurchaseOrderDto::fromEntity);
    }

    public Page<PurchaseOrderItemDto> getPurchaseOrderItemsByPurchaseOrderNumber
            (PurchaseOrderId purchaseOrderId, int pageNumber, int pageSize) {
        var pageable = PageRequest.of(pageNumber - 1, pageSize);
        var items = purchaseOrderItemRepository
                .findByPurchaseOrderPurchaseOrderIdOrderByPurchaseOrderItemIdItem(purchaseOrderId, pageable);
        return items.map(PurchaseOrderItemDto::fromEntity);
    }

}
