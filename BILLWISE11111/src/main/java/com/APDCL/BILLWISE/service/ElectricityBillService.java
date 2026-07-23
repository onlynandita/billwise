package com.APDCL.BILLWISE.service;

import com.APDCL.BILLWISE.entity.ElectricityBill;

import java.util.List;

public interface ElectricityBillService {

    // Save Bill
    ElectricityBill saveBill(ElectricityBill bill);

    // Get All Bills
    List<ElectricityBill> getAllBills();

    // Get Latest Bill
    ElectricityBill getLatestBill();

    // Get Bill By ID
    ElectricityBill getBillById(Long id);

    // Delete Bill
    void deleteBill(Long id);

    // Get Last 6 Months History of Current Consumer
    List<ElectricityBill> getLast6Bills(Long consumerNumber);

}
