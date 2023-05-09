package com.grupolainmaculada.cloud.inventoryservice.supplier.dto;

import com.grupolainmaculada.cloud.inventoryservice.supplier.domain.Supplier;

public record SupplierDto(String supplierId, String businessName, String documentNumber) {

    public static SupplierDto fromEntity(Supplier supplier) {
        return new SupplierDto(
                supplier.getSupplierId().getCode(),
                supplier.getBusinessName(),
                supplier.getDoi());
    }
}
