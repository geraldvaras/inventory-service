package com.grupolainmaculada.cloud.inventoryservice.product.service;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.*;
import com.grupolainmaculada.cloud.inventoryservice.product.dto.ProductoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public ProductoDto viewProductDetails(ProductId id) {
        var entity = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        return ProductoDto.fromEntity(entity);
    }

    public ProductoDto searchActiveProductDetailByBarCode(
            String organizationId, String branchId, String warehouseId, String barCode) {
        Product entity = this.productRepository
                .findActiveByBarCode(organizationId, branchId, warehouseId, barCode)
                .orElseThrow(() -> new BarCodeNotFoundException(barCode));
        return ProductoDto.fromEntity(entity);
    }

    public Page<ProductoDto> searchActiveProductsByDescription
            (String organizationId, String branchId, String warehouseId,
             String term, int pageNumber, int pageSize) {
        if (term == null || term.length() < 3) {
            return Page.empty();
        }
        String searchTerm = term.concat("%");
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        var suppliers = productRepository
                .findActiveByDescription(organizationId, branchId, warehouseId, searchTerm, pageable);
        return suppliers.map(ProductoDto::fromEntity);
    }
}
