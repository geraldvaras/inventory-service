package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, ProductId> {
    Optional<Product> findById(ProductId id);

    boolean existsById(ProductId id);

    @Query("""
            select p from Product p left join BarCode b
            on p.id = b.barCodeId.productId
            where p.id.organizationId = ?1 and  p.id.branchId = ?2
            and p.id.warehouseId = ?3 and b.barCodeId.barCode = ?4
            and b.state = 1
            """)
    Optional<Product> findActiveByBarCode(String organizationId, String branchId, String warehouseId, String barCode);

    @Query("""
            select p from Product  p 
            where p.id.organizationId = ?1 and p.id.branchId = ?2 and p.id.warehouseId = ?3 and 
            p.description like ?4
            """)
    Page<Product> findActiveByDescription
            (String organizationId, String branchId, String warehouseId, String term, Pageable pageable);
}