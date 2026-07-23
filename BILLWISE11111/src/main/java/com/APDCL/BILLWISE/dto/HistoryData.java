package com.APDCL.BILLWISE.dto;

public class HistoryData {

    private String statement;
    private String units;
    private String billAmount;
    private String recharge;

    public HistoryData() {
    }

    public HistoryData(String statement, String units, String billAmount, String recharge) {
        this.statement = statement;
        this.units = units;
        this.billAmount = billAmount;
        this.recharge = recharge;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public String getRecharge() {
        return recharge;
    }

    public void setRecharge(String recharge) {
        this.recharge = recharge;
    }

    @Override
    public String toString() {
        return "HistoryData{" +
                "statement='" + statement + '\'' +
                ", units='" + units + '\'' +
                ", billAmount='" + billAmount + '\'' +
                ", recharge='" + recharge + '\'' +
                '}';
    }
}
