package com.APDCL.BILLWISE.dto;

import java.util.List;

public class BillData {

    private String consumerNumber;
    private String consumerName;
    private String billingMonth;
    private String totalUnits;
    private String billAmount;
    private String dueDate;
    private String meterNumber;

    // Last 6 Months History
    private List<HistoryData> history;

    // Default Constructor
    public BillData() {
    }

    public String getConsumerNumber() {
        return consumerNumber;
    }

    public void setConsumerNumber(String consumerNumber) {
        this.consumerNumber = consumerNumber;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getBillingMonth() {
        return billingMonth;
    }

    public void setBillingMonth(String billingMonth) {
        this.billingMonth = billingMonth;
    }

    public String getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(String totalUnits) {
        this.totalUnits = totalUnits;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public List<HistoryData> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryData> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "BillData{" +
                "consumerNumber='" + consumerNumber + '\'' +
                ", consumerName='" + consumerName + '\'' +
                ", billingMonth='" + billingMonth + '\'' +
                ", totalUnits='" + totalUnits + '\'' +
                ", billAmount='" + billAmount + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", meterNumber='" + meterNumber + '\'' +
                ", history=" + history +
                '}';
    }
}