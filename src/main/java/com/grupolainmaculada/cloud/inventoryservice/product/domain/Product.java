package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "PRODUCTOS")
public class Product {

    @EmbeddedId
    @Valid
    private ProductId id;

    @Column(name = "DESPROD")
    @NotBlank(message = "The description must be defined.")
    private String description;

    @Column(name = "FRACCIONES")
    @NotNull(message = "The fraction must be defined.")
    @Positive(message = "The fraction must be greater than zero.")
    private Integer fraction;

    @Column(name = "PRECOSTO")
    @NotNull(message = "The unit price must be defined.")
    @Positive(message = "The unit price must be greater than zero.")
    private BigDecimal unitPrice;

    @Column(name = "PREUNI")
    @NotNull(message = "The unit cost must be defined.")
    @Positive(message = "The unit cost must be greater than zero.")
    private BigDecimal unitCost;

    @Version
    @Column(name = "VERSION")
    private Integer version;

    @CreatedDate
    @Column(name = "ROWFECHAHORA")
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "UPDATEFECHAHORA")
    private Instant lastModifiedDate;

    public static Product of(ProductId id, String description, Integer fraction, BigDecimal unitPrice, BigDecimal unitCost){
        return new Product(id, description, fraction, unitPrice, unitCost, 0, null, null);
    }
}
