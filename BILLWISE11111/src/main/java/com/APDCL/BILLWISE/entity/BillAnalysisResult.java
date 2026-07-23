package com.APDCL.BILLWISE.entity;
import jakarta.persistence.*;

import org.springframework.boot.persistence.autoconfigure.EntityScan;

@Entity
@Table(name="bill_analysis_result")

public class BillAnalysisResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prediction;

    private Double confidenceScore;

    private String analysisSummary;

    private String recommendation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }

    public String getAnalysisSummary() {
        return analysisSummary;
    }

    public void setAnalysisSummary(String analysisSummary) {
        this.analysisSummary = analysisSummary;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
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
