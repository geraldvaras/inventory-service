package com.grupolainmaculada.cloud.inventoryservice.product.web;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.Product;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductId;
import com.grupolainmaculada.cloud.inventoryservice.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> get() {
        return productService.viewProductList();
    }

    @GetMapping("{code}")
    public Product getById(
            @RequestHeader("Organization-Id") String organizationId,
            @RequestHeader("Branch-Id") String branchId,
            @PathVariable String code) {
        ProductId id = ProductId.of(organizationId, branchId, code);
        return productService.viewProductDetails(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product post(@Valid @RequestBody Product product) {
        return productService.addProductToCatalog(product);
    }

    @DeleteMapping("{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @RequestHeader("Organization-Id") String organizationId,
            @RequestHeader("Branch-Id") String branchId,
            @PathVariable String code) {
        ProductId id = ProductId.of(organizationId, branchId, code);
        productService.removeProductCatalog(id);
    }

    @PutMapping("{code}")
    public Product put(
            @RequestHeader("Organization-Id") String organizationId,
            @RequestHeader("Branch-Id") String branchId,
            @PathVariable String code, @Valid @RequestBody Product product) {
        ProductId id = ProductId.of(organizationId, branchId, code);
        return productService.editProductDetails(id, product);
    }
}
