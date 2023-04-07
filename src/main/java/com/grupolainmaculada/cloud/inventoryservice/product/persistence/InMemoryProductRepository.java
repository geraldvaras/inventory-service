package com.grupolainmaculada.cloud.inventoryservice.product.persistence;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.Product;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductId;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class  InMemoryProductRepository implements ProductRepository {

    private static final Map<ProductId, Product> products = new ConcurrentHashMap<>();

    @Override
    public Iterable<Product> findAll() {
        return products.values();
    }

    @Override
    public Optional<Product> findById(ProductId id) {
        return existsById(id)
                ? Optional.of(products.get(id))
                : Optional.empty();
    }

    @Override
    public boolean existsById(ProductId id) {
        return products.get(id) != null;
    }

    @Override
    public Product save(Product product) {
        products.put(product.id(), product);
        return product;
    }

    @Override
    public void deleteById(ProductId id) {
        products.remove(id);
    }
}
