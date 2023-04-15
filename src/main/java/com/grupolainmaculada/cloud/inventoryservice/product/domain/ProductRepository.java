package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, ProductId> {
    Optional<Product> findById(ProductId id);
    boolean existsById(ProductId id);
}