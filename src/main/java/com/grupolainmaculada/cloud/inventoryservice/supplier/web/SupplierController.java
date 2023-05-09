package com.grupolainmaculada.cloud.inventoryservice.supplier.web;

import com.grupolainmaculada.cloud.inventoryservice.supplier.dto.SupplierDto;
import com.grupolainmaculada.cloud.inventoryservice.supplier.service.SupplierService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/search/by-business-name-or-doi/{term}")
    public Page<SupplierDto> getByBusinessNameOrDoi(
            @RequestHeader("Organization-Id") String organizationId,
            @PathVariable String term,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            @RequestParam(value = "size", defaultValue = "10") int pageSize) {
        return this.supplierService
                .searchActiveSuppliersByBusinessNameOrDoi(organizationId, term, pageNumber, pageSize);
    }

}
