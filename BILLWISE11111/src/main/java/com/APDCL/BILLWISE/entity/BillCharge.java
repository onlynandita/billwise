package com.APDCL.BILLWISE.entity;
import jakarta.persistence.*;

import org.springframework.boot.persistence.autoconfigure.EntityScan;

@Entity
@Table(name="bill_charge")

public class BillCharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chargeName;

    private Double units;

    private Double rate;

    private Double amount;

    private String chargeType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
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
