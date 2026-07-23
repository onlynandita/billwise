package com.APDCL.BILLWISE.entity;
import jakarta.persistence.*;

import org.springframework.boot.persistence.autoconfigure.EntityScan;

@Entity
@Table(name="meter_reading")
public class MeterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String meterNumber;

    private String readingType;

    private Double previousReadingKwh;

    private Double currentReadingKwh;

    private Double differenceReadingKwh;

    private Double unitConsumed;

    private Double billableUnitsKwh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeterNumber() {
        return meterNumber;
    }

    public void setMeterNumber(String meterNumber) {
        this.meterNumber = meterNumber;
    }

    public String getReadingType() {
        return readingType;
    }

    public void setReadingType(String readingType) {
        this.readingType = readingType;
    }

    public Double getPreviousReadingKwh() {
        return previousReadingKwh;
    }

    public void setPreviousReadingKwh(Double previousReadingKwh) {
        this.previousReadingKwh = previousReadingKwh;
    }

    public Double getCurrentReadingKwh() {
        return currentReadingKwh;
    }

    public void setCurrentReadingKwh(Double currentReadingKwh) {
        this.currentReadingKwh = currentReadingKwh;
    }

    public Double getDifferenceReadingKwh() {
        return differenceReadingKwh;
    }

    public void setDifferenceReadingKwh(Double differenceReadingKwh) {
        this.differenceReadingKwh = differenceReadingKwh;
    }

    public Double getUnitConsumed() {
        return unitConsumed;
    }

    public void setUnitConsumed(Double unitConsumed) {
        this.unitConsumed = unitConsumed;
    }

    public Double getBillableUnitsKwh() {
        return billableUnitsKwh;
    }

    public void setBillableUnitsKwh(Double billableUnitsKwh) {
        this.billableUnitsKwh = billableUnitsKwh;
    }

    public Double getMaximumDemand() {
        return maximumDemand;
    }

    public void setMaximumDemand(Double maximumDemand) {
        this.maximumDemand = maximumDemand;
    }

    private Double maximumDemand;

}
