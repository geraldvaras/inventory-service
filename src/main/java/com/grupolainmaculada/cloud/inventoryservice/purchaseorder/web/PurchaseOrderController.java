package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.web;

import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain.PurchaseOrderId;
import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.dto.PurchaseOrderDto;
import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.dto.PurchaseOrderItemDto;
import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.service.PurchaseOrderService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    public PurchaseOrderController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping("/search/by-supplier/{supplierId}")
    public Page<PurchaseOrderDto> getBySupplierId(
            @RequestHeader("Organization-Id") String organizationId,
            @RequestHeader("Branch-Id") String branchId,
            @RequestHeader("Warehouse-Id") String warehouseId,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            @RequestParam(value = "size", defaultValue = "10") int pageSize,
            @PathVariable String supplierId) {
        return purchaseOrderService.getPurchaseOrdersBySupplierId
                (organizationId, branchId, supplierId, pageNumber, pageSize);
    }

    @GetMapping("/search-detail/by-order-number/{purchaseOrderNumber}")
    public Page<PurchaseOrderItemDto> getByPurchaseOrderNumber(
            @RequestHeader("Organization-Id") String organizationId,
            @RequestHeader("Branch-Id") String branchId,
            @RequestHeader("Warehouse-Id") String warehouseId,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            @RequestParam(value = "size", defaultValue = "10") int pageSize,
            @PathVariable String purchaseOrderNumber) {
        var purchaseOrderId = PurchaseOrderId.of(organizationId, branchId, purchaseOrderNumber);
        return purchaseOrderService
                .getPurchaseOrderItemsByPurchaseOrderNumber(purchaseOrderId, pageNumber, pageSize);
    }
}
