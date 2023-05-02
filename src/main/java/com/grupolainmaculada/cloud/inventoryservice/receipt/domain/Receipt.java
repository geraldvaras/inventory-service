package com.grupolainmaculada.cloud.inventoryservice.receipt.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "RECEPCIONCAB")
public class Receipt {

    @EmbeddedId
    private ReceiptId receiptId;

    @OneToMany(mappedBy = "receipt", fetch = FetchType.LAZY)
    private Set<ReceiptItem> items = new HashSet<>();

    @Column(name = "TIPODOC")
    private String documentType;

    @Column(name = "NUMDOC")
    private String documentNumber;

    @Column(name = "SERIEDOC")
    private String documentSeries;

    @Column(name = "CODPROV")
    private String supplierCode;

    @Column(name = "OBSERVACION")
    private String observations;

    @Column(name = "FECHAFAC")
    private LocalDate issueDate;

    @Column(name = "FECHAVENC")
    private LocalDate dueDate;

    @Column(name = "SOLOBONIFICACION")
    private Boolean isOnlyBonus;

    @CreatedDate
    @Column(name = "ROWFECHAHORA")
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "UPDATEFECHAHORA")
    private Instant lastModifiedDate;

    public ReceiptId getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(ReceiptId receiptId) {
        this.receiptId = receiptId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentSeries() {
        return documentSeries;
    }

    public void setDocumentSeries(String documentSeries) {
        this.documentSeries = documentSeries;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getOnlyBonus() {
        return isOnlyBonus;
    }

    public void setOnlyBonus(Boolean onlyBonus) {
        isOnlyBonus = onlyBonus;
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

    public Set<ReceiptItem> getItems() {
        return items;
    }

    public void setItems(Set<ReceiptItem> items) {
        this.items = items;
    }

    private Receipt(
            ReceiptId receiptId, String documentType, String documentNumber,
            String documentSeries, String supplierCode, String observations,
            LocalDate issueDate, LocalDate dueDate, Boolean isOnlyBonus,
            Instant createdDate, Instant lastModifiedDate) {
        this.receiptId = receiptId;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.documentSeries = documentSeries;
        this.supplierCode = supplierCode;
        this.observations = observations;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.isOnlyBonus = isOnlyBonus;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Receipt() {
    }

    public static Receipt of(
            ReceiptId id, String documentType, String documentNumber, String documentSeries, String supplierCode,
            String observations, LocalDate issueDate, LocalDate dueDate, Boolean isOnlyBonus) {
        return new Receipt(id, documentType, documentNumber, documentSeries, supplierCode,
                observations, issueDate, dueDate, isOnlyBonus, null, null);
    }
}
