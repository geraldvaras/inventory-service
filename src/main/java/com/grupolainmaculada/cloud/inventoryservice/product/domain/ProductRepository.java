package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import java.util.Optional;

public interface ProductRepository {
    Iterable<Product> findAll();
    Optional<Product> findById(ProductId id);
    boolean existsById(ProductId id);
    Product save(Product product);
    void deleteById(ProductId productId);
}
