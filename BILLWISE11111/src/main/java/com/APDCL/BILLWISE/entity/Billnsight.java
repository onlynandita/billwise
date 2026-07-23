package com.APDCL.BILLWISE.entity;
import jakarta.persistence.*;

import org.springframework.boot.persistence.autoconfigure.EntityScan;

@Entity
@Table(name="bill_n_sight")

public class Billnsight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String insightType;

    private String insightMessage;

    private String severity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInsightType() {
        return insightType;
    }

    public void setInsightType(String insightType) {
        this.insightType = insightType;
    }

    public String getInsightMessage() {
        return insightMessage;
    }

    public void setInsightMessage(String insightMessage) {
        this.insightMessage = insightMessage;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public ElectricityBill getElectricityBill() {
        return electricityBill;
    }

    public void setElectricityBill(ElectricityBill electricityBill) {
        this.electricityBill = electricityBill;
    }

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private ElectricityBill electricityBill;

}

