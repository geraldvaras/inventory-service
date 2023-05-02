package com.grupolainmaculada.cloud.inventoryservice.supplier.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SupplierId implements Serializable {

    @Column(name = "CODEMP")
    private String organizationId;

    @Column(name = "CODPROV")
    private String code;

    public static SupplierId of(String organizationId, String code) {
        return new SupplierId(organizationId, code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SupplierId that = (SupplierId) o;

        if (!organizationId.equals(that.organizationId)) return false;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        int result = organizationId.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }
}
