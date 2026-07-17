package com.APDCL.BILLWISE.controller;

import com.APDCL.BILLWISE.entity.BillCharge;
import com.APDCL.BILLWISE.service.BillChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill-charges")
public class BillChargeController {

    @Autowired
    private BillChargeService billChargeService;

    @PostMapping
    public BillCharge saveCharge(@RequestBody BillCharge charge) {
        return billChargeService.saveCharge(charge);
    }

    @GetMapping
    public List<BillCharge> getAllCharges() {
        return billChargeService.getAllCharges();
    }

    @GetMapping("/{id}")
    public BillCharge getChargeById(@PathVariable Long id) {
        return billChargeService.getChargeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCharge(@PathVariable Long id) {
        billChargeService.deleteCharge(id);
        return "Bill Charge deleted successfully";
    }
}