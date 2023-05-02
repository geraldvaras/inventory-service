package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "OCOMITE")
public class PurchaseOrderItem {

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("purchaseOrderId")
    @JoinColumns({
            @JoinColumn(name = "CODSUC", referencedColumnName = "CODSUC"),
            @JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP"),
            @JoinColumn(name = "NUMORDENCOM", referencedColumnName = "NUMORDENCOM")
    })
    private PurchaseOrder purchaseOrder;
    @EmbeddedId
    private PurchaseOrderItemId purchaseOrderItemId;

    @Column(name = "CODPROD")
    private String productCode;

    @Column(name = "DESPROD")
    private String productDescription;

    @Column(name = "DESPRES")
    private String productPresentation;

    @Column(name = "FRACCION")
    private Integer fraction;

    @Column(name = "CANDES")
    private Integer integerQuantity;

    @Column(name = "CANDESMIN")
    private Integer fractionalQuantity;

    @Column(name = "CANBONI")
    private Integer bonusQuantity;

    @Column(name = "TOTCANTMIN")
    private Integer totalQuantity;

    public PurchaseOrderItem() {
    }

    private PurchaseOrderItem(
            PurchaseOrder purchaseOrder, PurchaseOrderItemId id, String productCode, String productDescription,
            String productPresentation, Integer fraction, Integer integerQuantity, Integer fractionalQuantity,
            Integer bonusQuantity, Integer totalQuantity) {
        this.purchaseOrder = purchaseOrder;
        this.purchaseOrderItemId = id;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.productPresentation = productPresentation;
        this.fraction = fraction;
        this.integerQuantity = integerQuantity;
        this.fractionalQuantity = fractionalQuantity;
        this.bonusQuantity = bonusQuantity;
        this.totalQuantity = totalQuantity;
    }

    public static PurchaseOrderItem of(
            PurchaseOrder purchaseOrder, PurchaseOrderItemId id, String productCode, String productDescription,
            String productPresentation, Integer fraction, Integer integerQuantity, Integer fractionalQuantity,
            Integer bonusQuantity, Integer totalQuantity) {
        return new PurchaseOrderItem(purchaseOrder, id, productCode, productDescription,
                productPresentation, fraction, integerQuantity, fractionalQuantity, bonusQuantity,
                totalQuantity);
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public PurchaseOrderItemId getPurchaseOrderItemId() {
        return purchaseOrderItemId;
    }

    public void setPurchaseOrderItemId(PurchaseOrderItemId id) {
        this.purchaseOrderItemId = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPresentation() {
        return productPresentation;
    }

    public void setProductPresentation(String productPresentation) {
        this.productPresentation = productPresentation;
    }

    public Integer getFraction() {
        return fraction;
    }

    public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }

    public Integer getIntegerQuantity() {
        return integerQuantity;
    }

    public void setIntegerQuantity(Integer integerQuantity) {
        this.integerQuantity = integerQuantity;
    }

    public Integer getFractionalQuantity() {
        return fractionalQuantity;
    }

    public void setFractionalQuantity(Integer fractionalQuantity) {
        this.fractionalQuantity = fractionalQuantity;
    }

    public Integer getBonusQuantity() {
        return bonusQuantity;
    }

    public void setBonusQuantity(Integer bonusQuantity) {
        this.bonusQuantity = bonusQuantity;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}