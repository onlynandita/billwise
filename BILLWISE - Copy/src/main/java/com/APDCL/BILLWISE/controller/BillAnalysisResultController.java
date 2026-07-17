package com.APDCL.BILLWISE.controller;

import com.APDCL.BILLWISE.entity.BillAnalysisResult;
import com.APDCL.BILLWISE.service.BillAnalysisResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill-analysis-results")
public class BillAnalysisResultController {

    @Autowired
    private BillAnalysisResultService billAnalysisResultService;

    @PostMapping
    public BillAnalysisResult saveResult(@RequestBody BillAnalysisResult result) {
        return billAnalysisResultService.saveResult(result);
    }

    @GetMapping
    public List<BillAnalysisResult> getAllResults() {
        return billAnalysisResultService.getAllResults();
    }

    @GetMapping("/{id}")
    public BillAnalysisResult getResultById(@PathVariable Long id) {
        return billAnalysisResultService.getResultById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteResult(@PathVariable Long id) {
        billAnalysisResultService.deleteResult(id);
        return "Bill Analysis Result deleted successfully";
    }
}
