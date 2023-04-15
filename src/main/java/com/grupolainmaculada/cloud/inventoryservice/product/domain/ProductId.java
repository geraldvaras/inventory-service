package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductId implements Serializable {

    @Column(name = "CODEMP")
    @NotBlank(message = "The organization id must be defined.")
    private String organizationId;

    @Column(name = "CODSUC")
    @NotBlank(message = "The branch id must be defined.")
    private String branchId;

    @Column(name = "CODALM")
    @NotBlank(message = "The warehouse id must be defined.")
    private String warehouseId;

    @Column(name = "CODPROD")
    @NotBlank(message = "The product code must be defined.")
    @Pattern(regexp = "^([0-9]{8})$", message = "The product code format must be valid.")
    private String code;


    public static ProductId of(String organizationId, String branchId, String warehouseId, String code) {
        return new ProductId(organizationId, branchId, warehouseId, code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductId productId = (ProductId) o;

        if (!organizationId.equals(productId.organizationId)) return false;
        if (!branchId.equals(productId.branchId)) return false;
        return code.equals(productId.code);
    }

    @Override
    public int hashCode() {
        int result = organizationId.hashCode();
        result = 31 * result + branchId.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }
}
