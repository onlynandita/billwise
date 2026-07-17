package com.APDCL.BILLWISE.controller;

import com.APDCL.BILLWISE.entity.MonthlyConsumptionHistory;
import com.APDCL.BILLWISE.service.MonthlyConsumptionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monthly-consumption-history")
public class MonthlyConsumptionHistoryController {

    @Autowired
    private MonthlyConsumptionHistoryService monthlyConsumptionHistoryService;

    @PostMapping
    public MonthlyConsumptionHistory saveHistory(@RequestBody MonthlyConsumptionHistory history) {
        return monthlyConsumptionHistoryService.saveHistory(history);
    }

    @GetMapping
    public List<MonthlyConsumptionHistory> getAllHistory() {
        return monthlyConsumptionHistoryService.getAllHistory();
    }

    @GetMapping("/{id}")
    public MonthlyConsumptionHistory getHistoryById(@PathVariable Long id) {
        return monthlyConsumptionHistoryService.getHistoryById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteHistory(@PathVariable Long id) {
        monthlyConsumptionHistoryService.deleteHistory(id);
        return "History deleted successfully";
    }
}
