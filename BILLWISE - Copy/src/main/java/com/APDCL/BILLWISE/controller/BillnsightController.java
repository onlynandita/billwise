package com.APDCL.BILLWISE.controller;

import com.APDCL.BILLWISE.entity.Billnsight;
import com.APDCL.BILLWISE.service.BillnsightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill-insights")
public class BillnsightController {

    @Autowired
    private BillnsightService billnsightService;

    @PostMapping
    public Billnsight saveInsight(@RequestBody Billnsight insight) {
        return billnsightService.saveInsight(insight);
    }

    @GetMapping
    public List<Billnsight> getAllInsights() {
        return billnsightService.getAllInsights();
    }

    @GetMapping("/{id}")
    public Billnsight getInsightById(@PathVariable Long id) {
        return billnsightService.getInsightById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteInsight(@PathVariable Long id) {
        billnsightService.deleteInsight(id);
        return "Bill Insight deleted successfully";
    }
}
