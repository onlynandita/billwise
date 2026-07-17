
package com.APDCL.BILLWISE.dto;

public class BillData {

    private String consumerNumber;
    private String consumerName;
    private String billingMonth;
    private String totalUnits;
    private String billAmount;
    private String dueDate;
    private String meterNumber;

    // Default Constructor
    public BillData() {
    }

    // Getters and Setters

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
                '}';
    }
}
