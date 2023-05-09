package com.grupolainmaculada.cloud.inventoryservice.supplier.service;

import com.grupolainmaculada.cloud.inventoryservice.supplier.domain.Supplier;
import com.grupolainmaculada.cloud.inventoryservice.supplier.domain.SupplierRepository;
import com.grupolainmaculada.cloud.inventoryservice.supplier.dto.SupplierDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Iterable<SupplierDto> viewActiveSuppliers() {
        var suppliers = supplierRepository.findAllByStateTrue();
        return suppliers.stream()
                .map(x -> new SupplierDto(
                        x.getSupplierId().getCode(), x.getBusinessName(), x.getDoi())
                )
                .toList();
    }

    public Page<SupplierDto> searchActiveSuppliersByBusinessNameOrDoi(
            String organizationId, String term, int pageNumber, int pageSize) {
        if (term == null || term.length() < 3) {
            return Page.empty();
        }
        String searchTerm = term.concat("%");
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        var suppliers = supplierRepository
                .findAllBySupplierIdOrganizationIdAndStateTrueAndBusinessNameLikeIgnoreCaseOrDoiLikeIgnoreCase
                        (organizationId, searchTerm, searchTerm, pageable);
        return suppliers.map(SupplierDto::fromEntity);
    }

}
