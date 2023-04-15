package com.grupolainmaculada.cloud.inventoryservice.product.service;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> viewProductList() {
        return productRepository.findAll();
    }

    public Product viewProductDetails(ProductId id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }


    public Product addProductToCatalog(Product product) {
        if (productRepository.existsById(product.getId())) {
            throw new ProductAlreadyExistsException(product.getId());
        }
        return productRepository.save(product);
    }

    public void removeProductCatalog(ProductId id) {
        productRepository.deleteById(id);
    }

    public Product editProductDetails(ProductId id, Product product) {
        return productRepository.findById(id)
                .map(existinProduct -> {
                    Product.of(
                            existinProduct.getId(),
                            product.getDescription(),
                            product.getFraction(),
                            product.getUnitPrice(),
                            product.getUnitCost());
                    return productRepository.save(product);
                }).orElseGet(() -> addProductToCatalog(product));
    }
}
