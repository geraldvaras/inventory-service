package com.grupolainmaculada.cloud.inventoryservice.receipt.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "RECEPCIONTIPOOBSERVACION")
public class ReceiptObservationType {

    @EmbeddedId
    private  ReceiptObservationTypeId id;

    @Column(name = "DESCRIPCION")
    private String description;

    @Column(name = "ACCION")
    private String action;

    @CreatedDate
    @Column(name = "FECHAREGISTRO", updatable = false)
    private Instant createdDate;

    @Column(name = "ESTADO")
    private Integer state;

    public ReceiptObservationType() {}

    private ReceiptObservationType(ReceiptObservationTypeId id, String description, String action, Instant createdDate, Integer state) {
        this.id = id;
        this.description = description;
        this.action = action;
        this.createdDate = createdDate;
        this.state = state;
    }

    public static ReceiptObservationType of(
            ReceiptObservationTypeId id, String  description, String action, Integer state) {
        return new ReceiptObservationType(id, description, action, null, state);
    }

    public ReceiptObservationTypeId getId() {
        return id;
    }

    public void setId(ReceiptObservationTypeId id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer estado) {
        this.state = estado;
    }


}
