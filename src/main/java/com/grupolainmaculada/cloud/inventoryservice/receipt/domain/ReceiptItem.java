package com.grupolainmaculada.cloud.inventoryservice.receipt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "RECEPCIONDET")
public class ReceiptItem {

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("receiptId")
    @JoinColumns({
            @JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP"),
            @JoinColumn(name = "CODSUC", referencedColumnName = "CODSUC"),
            @JoinColumn(name = "CODALM", referencedColumnName = "CODALM"),
            @JoinColumn(name = "INTERNO", referencedColumnName = "INTERNO")
    })
    private Receipt receipt;

    @EmbeddedId
    private ReceiptItemId receiptItemId;

    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumns({
            @JoinColumn(name = "CODEMP", referencedColumnName = "CODEMP", updatable = false, insertable = false),
            @JoinColumn(name = "IDTIPOOBSERVACION", referencedColumnName = "IDTIPOOBSERVACION", updatable = false, insertable = false)
    })
    private ReceiptObservationType receiptObservationType;

    @Column(name = "ORDEN")
    private Integer orderNumber;

    @Column(name = "CODPROD")
    private String productCode;

    @Column(name = "DESPROD")
    private String productDescription;

    @Column(name = "FRACCION")
    private Integer productFraction;

    @Column(name = "CODBAR")
    private String productBarCode;

    @Column(name = "UNIMED")
    private String productUnitMeasurement;

    @Column(name = "UNIMEDMIN")
    private String productFractionalMeasurement;

    @Column(name = "CANDES")
    private Integer productIntegerQuantity;

    @Column(name = "CANDESMIN")
    private Integer productFractionalQuantity;

    @Column(name = "CANBONI")
    private Integer productBonusQuantity;

    @Column(name = "TOTCANTMIN")
    private Integer productTotalQuantity;

    @Column(name = "CANDES_COM")
    private Integer purchaseOrderIntegerQuantity;

    @Column(name = "CANDESMIN_COM")
    private Integer purchaseOrderFractionalQuantity;

    @Column(name = "CANBONI_COM")
    private Integer purchaseOrderBonusQuantity;

    @Column(name = "TOTCANTMIN_COM")
    private Integer purchaseOrderTotalQuantity;

    @Column(name = "IDTIPOOBSERVACION")
    private Integer observationCode;

    @Column(name = "OBSERVACION")
    private String observationDescription;

    @Column(name = "CANDES_FAC")
    private Integer invoiceIntegerQuantity;

    @Column(name = "CANDESMIN_FAC")
    private Integer invoiceFractionalQuantity;

    @Column(name = "CANBONI_FAC")
    private Integer invoiceBonusQuantity;

    @Column(name = "TOTCANTMIN_FAC")
    private Integer invoiceTotalQuantity;

    @Column(name = "LOTE")
    private String batchNumber;

    @Column(name = "FECHAVENC")
    private LocalDate expirationDate;

    @Column(name = "FLAGDIF_FACTURA")
    private Boolean isDifferentFromInvoice;

    @Column(name = "FLAGDIF_COMPRA")
    private Boolean isDifferentFromPurchaseOrder;

    @Column(name = "SOLOBONIFICACION")
    private Boolean isOnlyForBonus;

}
