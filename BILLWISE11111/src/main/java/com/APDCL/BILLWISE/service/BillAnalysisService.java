package com.APDCL.BILLWISE.service;

import com.APDCL.BILLWISE.dto.BillAnalysisResponse;
import com.APDCL.BILLWISE.entity.ElectricityBill;
import com.APDCL.BILLWISE.repository.ElectricityBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillAnalysisService {

    @Autowired
    private ElectricityBillRepository repository;

    public BillAnalysisResponse analyzeLatestBill() {

        ElectricityBill bill =
                repository.findTopByOrderByIdDesc();

        BillAnalysisResponse response =
                new BillAnalysisResponse();

        response.setConsumerName(bill.getConsumerName());
        response.setBillAmount(bill.getBillAmount());

        if (bill.getBillAmount() > 5000) {
            response.setStatus("High");
            response.setSuggestion(
                    "High electricity consumption detected. Consider reducing usage during peak hours.");
        } else if (bill.getBillAmount() > 3000) {
            response.setStatus("Normal");
            response.setSuggestion(
                    "Electricity consumption is within the normal range.");
        } else {
            response.setStatus("Low");
            response.setSuggestion(
                    "Your electricity bill is low. Good energy efficiency.");
        }

        return response;
    }
}
