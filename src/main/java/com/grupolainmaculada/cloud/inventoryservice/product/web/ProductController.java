package com.grupolainmaculada.cloud.inventoryservice.product.web;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.Product;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductId;
import com.grupolainmaculada.cloud.inventoryservice.product.dto.ProductoDto;
import com.grupolainmaculada.cloud.inventoryservice.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> get() {
        return productService.viewProductList();
    }

    @GetMapping("/search/by-code/{code}")
    public ProductoDto getById(
            @RequestHeader("Organization-Id") String organizationId,
            @RequestHeader("Branch-Id") String branchId,
            @RequestHeader("Warehouse-Id") String warehouseId,
            @PathVariable String code) {
        ProductId id = ProductId.of(organizationId, branchId, warehouseId, code);
        return productService.viewProductDetails(id);
    }

    @GetMapping("/search/by-barcode/{barCode}")
    public ProductoDto getByBarcode(@RequestHeader("Organization-Id") String organizationId,
                                    @RequestHeader("Branch-Id") String branchId,
                                    @RequestHeader("Warehouse-Id") String warehouseId,
                                    @PathVariable String barCode) {
        return productService.searchActiveProductDetailByBarCode(organizationId, branchId, warehouseId,barCode);
    }

    @GetMapping("/search/by-description/{term}")
    public Page<ProductoDto> gerByDescription(
            @RequestHeader("Organization-Id") String organizationId,
            @RequestHeader("Branch-Id") String branchId,
            @RequestHeader("Warehouse-Id") String warehouseId,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber,
            @RequestParam(value = "size", defaultValue = "10") int pageSize,
            @PathVariable String term) {
        return productService.searchActiveProductsByDescription
                (organizationId, branchId, warehouseId,term, pageNumber, pageSize );
    }

 /*
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
            @RequestHeader("Warehouse-Id") String warehouseId,
            @PathVariable String code) {
        ProductId id = ProductId.of(organizationId, branchId, warehouseId, code);
        productService.removeProductCatalog(id);
    }


    @PutMapping("{code}")
    public Product put(
            @RequestHeader("Organization-Id") String organizationId,
            @RequestHeader("Branch-Id") String branchId,
            @RequestHeader("Warehouse-Id") String warehouseId,
            @PathVariable String code, @Valid @RequestBody Product product) {
        ProductId id = ProductId.of(organizationId, branchId, warehouseId, code);
        return productService.editProductDetails(id, product);
    }
     */
}
