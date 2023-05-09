package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import com.grupolainmaculada.cloud.inventoryservice.common.domain.Fraction;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "PRODUCTOS")
public class Product {

    @EmbeddedId
    private ProductId id;

    @Column(name = "DESPROD")
    private String description;

    @Embedded
    @AttributeOverride(name = "fraction", column = @Column(name = "FRACCIONES"))
    private Fraction fraction;

    @Column(name = "PREUNI")
    private BigDecimal unitPrice;

    @Column(name = "PRECOSTO")
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

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @AttributeOverrides({
            @AttributeOverride(name = "CODEMP", column = @Column(name = "CODEMP")),
            @AttributeOverride(name = "CODSUC", column = @Column(name = "CODSUC")),
            @AttributeOverride(name = "CODALM", column = @Column(name = "CODALM")),
            @AttributeOverride(name = "CODPROD", column = @Column(name = "CODPROD")),
            @AttributeOverride(name = "barCodeId.barCode", column = @Column(name = "CODBAR"))

    })
    private Set<BarCode> barCode = new HashSet<>();

    @Column(name = "ESTPROD")
    private Integer state;

    private Product(ProductId id, String description,
                    Fraction fraction, BigDecimal unitPrice, BigDecimal unitCost,
                    Integer version,
                    Instant createdDate, Instant lastModifiedDate, Set<BarCode> barCode) {
        this.id = id;
        this.description = description;
        this.fraction = fraction;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.barCode = barCode;
    }

    public static Product of(ProductId productId, String description, Fraction fraction,
                             BigDecimal unitPrice, BigDecimal unitCost) {
        return new Product(productId, description, fraction, unitPrice, unitCost,
                null, null, null, null);
    }

    public Product() {
    }

    public ProductId getId() {
        return id;
    }

    private void setId(ProductId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public Fraction getFraction() {
        return fraction;
    }

    private void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    private void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    private void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getVersion() {
        return version;
    }

    private void setVersion(Integer version) {
        this.version = version;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    private void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    private void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<BarCode> getBarCode() {
        return barCode;
    }

    private void setBarCode(Set<BarCode> barCode) {
        this.barCode = barCode;
    }

    public Integer getState() {
        return state;
    }

    private void setState(Integer state) {
        this.state = state;
    }
}