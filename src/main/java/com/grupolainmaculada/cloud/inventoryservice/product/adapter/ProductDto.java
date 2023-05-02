package com.grupolainmaculada.cloud.inventoryservice.product.adapter;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.Product;
import lombok.Getter;

@Getter
public class ProductDto {

    private final String codProd;
    private final String desProd;

    public ProductDto(String codProd, String desProd) {
        this.codProd = codProd;
        this.desProd = desProd;
    }


}
