package com.APDCL.BILLWISE.entity;
import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;

import org.springframework.boot.persistence.autoconfigure.EntityScan;

@Entity
@Table(name="electricity_bill")

public class ElectricityBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String providerName;

    private String consumerName;

    private Long consumerNumber;

    private String address;

    private String statementMonth;

    private String billPeriodStart;

    private String billPeriodEnd;

    private Double connectedLoadKW;

    private Double sanctionedLoadKW;

    private Double billAmount;

    private Double totalMonthlyCharge;

    private Double openingBalance;

    private Double rechargeAmount;

    private Double finalBalance;
    private Double totalUnits;

    private Double averageDailyUsage;

    private Double effectiveCostPerUnit;

    private String usageTrend;

    public Double getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(Double totalUnits) {
        this.totalUnits = totalUnits;
    }

    public Double getAverageDailyUsage() {
        return averageDailyUsage;
    }

    public void setAverageDailyUsage(Double averageDailyUsage) {
        this.averageDailyUsage = averageDailyUsage;
    }

    public Double getEffectiveCostPerUnit() {
        return effectiveCostPerUnit;
    }

    public void setEffectiveCostPerUnit(Double effectiveCostPerUnit) {
        this.effectiveCostPerUnit = effectiveCostPerUnit;
    }

    public String getUsageTrend() {
        return usageTrend;
    }

    public void setUsageTrend(String usageTrend) {
        this.usageTrend = usageTrend;
    }

    public String getAiSuggestion() {
        return aiSuggestion;
    }

    public void setAiSuggestion(String aiSuggestion) {
        this.aiSuggestion = aiSuggestion;
    }

    private String aiSuggestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public Long getConsumerNumber() {
        return consumerNumber;
    }

    public void setConsumerNumber(Long consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatementMonth() {
        return statementMonth;
    }

    public void setStatementMonth(String statementMonth) {
        this.statementMonth = statementMonth;
    }

    public String getBillPeriodStart() {
        return billPeriodStart;
    }

    public void setBillPeriodStart(String billPeriodStart) {
        this.billPeriodStart = billPeriodStart;
    }

    public String getBillPeriodEnd() {
        return billPeriodEnd;
    }

    public void setBillPeriodEnd(String billPeriodEnd) {
        this.billPeriodEnd = billPeriodEnd;
    }

    public Double getConnectedLoadKW() {
        return connectedLoadKW;
    }

    public void setConnectedLoadKW(Double connectedLoadKW) {
        this.connectedLoadKW = connectedLoadKW;
    }

    public Double getSanctionedLoadKW() {
        return sanctionedLoadKW;
    }

    public void setSanctionedLoadKW(Double sanctionedLoadKW) {
        this.sanctionedLoadKW = sanctionedLoadKW;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Double getTotalMonthlyCharge() {
        return totalMonthlyCharge;
    }

    public void setTotalMonthlyCharge(Double totalMonthlyCharge) {
        this.totalMonthlyCharge = totalMonthlyCharge;
    }

    public Double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(Double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public Double getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(Double rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(Double finalBalance) {
        this.finalBalance = finalBalance;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    private Integer numberOfDays;
}



