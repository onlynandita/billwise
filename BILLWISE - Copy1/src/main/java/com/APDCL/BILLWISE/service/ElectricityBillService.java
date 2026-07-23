package com.APDCL.BILLWISE.service;



import com.APDCL.BILLWISE.entity.ElectricityBill;
import java.util.List;

public interface ElectricityBillService {

    ElectricityBill saveBill(ElectricityBill bill);

    List<ElectricityBill> getAllBills();

    ElectricityBill getBillById(Long id);

    void deleteBill(Long id);
}
