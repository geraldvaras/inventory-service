package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "CODIGOBARRAPROD")
public class BarCode {

    @EmbeddedId
    private BarCodeId barCodeId;

    @Column(name = "ESTADO")
    private Integer state;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumns({
            @JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP"),
            @JoinColumn(name = "CODSUC", referencedColumnName = "CODSUC"),
            @JoinColumn(name = "CODALM", referencedColumnName = "CODALM"),
            @JoinColumn(name = "CODPROD", referencedColumnName = "CODPROD")
    })
    private Product product;

    public BarCode(){
    }

    public BarCodeId getBarCodeId() {
        return barCodeId;
    }

    public void setBarCodeId(BarCodeId barCodeId) {
        this.barCodeId = barCodeId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Product getProduct() {
        return product;
    }

    private void setProduct(Product product) {
        this.product = product;
    }
}
