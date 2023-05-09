package com.grupolainmaculada.cloud.inventoryservice.supplier.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "PROVEEDORES")
public class Supplier {

    @EmbeddedId
    private SupplierId supplierId;

    @Column(name = "COMPANIA")
    private String businessName;

    @Column(name = "RUC")
    private String doi;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @CreatedDate
    @Column(name = "FECHAREGISTRO", updatable = false)
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "ROWFECHAHORA")
    private Instant lastModifiedDate;

    @Column(name = "ESTADO")
    private Integer state;

    public Supplier(SupplierId supplierId, String businessName, String doi) {
        this.supplierId = supplierId;
        this.businessName = businessName;
        this.doi = doi;
    }

    public static Supplier of(SupplierId id, String businessName, String doi) {
        return new Supplier(id, businessName, doi);
    }
}
