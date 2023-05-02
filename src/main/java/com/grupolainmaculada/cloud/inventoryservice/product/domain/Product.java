package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;

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

    @Embedded
    private Fraction fraction;

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
    @Column(name = "ROWFECHAHORA", updatable = false)
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "UPDATEFECHAHORA")
    private Instant lastModifiedDate;

    public static Product of(ProductId id, String description, Fraction fraction,
                             BigDecimal unitPrice, BigDecimal unitCost) {
        return new Product(id, description, fraction, unitPrice, unitCost,
                0, null, null);
    }

    public Product(
            ProductId id, String description, Fraction fraction, BigDecimal unitPrice,
            BigDecimal unitCost, Integer version, Instant createdDate, Instant lastModifiedDate) {
        this.id = id;
        this.description = description;
        this.fraction = fraction;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Product() {}

    public ProductId getId() {
        return id;
    }

    public void setId(ProductId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}