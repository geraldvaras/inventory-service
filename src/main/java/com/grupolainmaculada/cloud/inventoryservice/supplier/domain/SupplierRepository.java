package com.grupolainmaculada.cloud.inventoryservice.supplier.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, SupplierId> {

    List<Supplier> findAllByStateTrue();

    Page<Supplier> findAllBySupplierIdOrganizationIdAndStateTrueAndBusinessNameLikeIgnoreCaseOrDoiLikeIgnoreCase(
            String organizationId, String businessName, String documentNumber, Pageable pageable);

}
