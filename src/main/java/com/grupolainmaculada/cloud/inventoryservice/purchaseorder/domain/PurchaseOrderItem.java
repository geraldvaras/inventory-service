package com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain;

import com.grupolainmaculada.cloud.inventoryservice.common.domain.Fraction;
import com.grupolainmaculada.cloud.inventoryservice.common.domain.ProductInfo;
import com.grupolainmaculada.cloud.inventoryservice.common.domain.Quantity;
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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "internalCode", column = @Column(name = "CODPROD")),
            @AttributeOverride(name = "description", column = @Column(name = "DESPROD")),
            @AttributeOverride(name = "presentation", column = @Column(name = "DESPRES")),
            @AttributeOverride(name = "barCode", column = @Column(name = "CODBAR"))

    })
    private ProductInfo productInfo;

    @Embedded
    @AttributeOverride(name = "fraction", column = @Column(name = "FRACCION"))
    private Fraction fraction;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "integer", column = @Column(name = "CANDES")),
            @AttributeOverride(name = "fractional", column = @Column(name = "CANDESMIN")),
            @AttributeOverride(name = "bonus", column = @Column(name = "CANBONI")),
            @AttributeOverride(name = "total", column = @Column(name = "TOTCANTMIN"))
    })
    private Quantity quantity;

    public PurchaseOrderItem() {
    }

    private PurchaseOrderItem(
            PurchaseOrder purchaseOrder, PurchaseOrderItemId id, ProductInfo productInfo, Fraction fraction, Quantity quantity) {
        this.purchaseOrder = purchaseOrder;
        this.purchaseOrderItemId = id;
        this.productInfo = productInfo;
        this.fraction = fraction;
        this.quantity = quantity;
    }

    public static PurchaseOrderItem of(
            PurchaseOrder purchaseOrder, PurchaseOrderItemId id, ProductInfo productInfo, Fraction fraction, Quantity quantity) {
        return new PurchaseOrderItem(purchaseOrder, id, productInfo, fraction, quantity);
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

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    private void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public Fraction getFraction() {
        return fraction;
    }

    private void setFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    private void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
}