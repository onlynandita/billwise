package com.APDCL.BILLWISE.service.impl;

import com.APDCL.BILLWISE.entity.ElectricityBill;
import com.APDCL.BILLWISE.repository.ElectricityBillRepository;
import com.APDCL.BILLWISE.service.ElectricityBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectricityBillServiceImpl implements ElectricityBillService {

    @Autowired
    private ElectricityBillRepository billRepository;

    @Override
    public ElectricityBill saveBill(ElectricityBill bill) {

        // Duplicate Check
        if (!billRepository.findByConsumerNumberAndStatementMonth(
                bill.getConsumerNumber(),
                bill.getStatementMonth()).isEmpty()) {

            throw new RuntimeException(
                    "Bill for this consumer and statement month already exists."
            );
        }

        return billRepository.save(bill);
    }

    @Override
    public List<ElectricityBill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public ElectricityBill getLatestBill() {
        return billRepository.findTopByOrderByIdDesc();
    }

    @Override
    public ElectricityBill getBillById(Long id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public List<ElectricityBill> getLast6Bills(Long consumerNumber) {
        return billRepository.findTop6ByConsumerNumberOrderByIdDesc(consumerNumber);
    }
}
