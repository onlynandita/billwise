package com.APDCL.BILLWISE.controller;

import com.APDCL.BILLWISE.dto.BillAnalysisResponse;
import com.APDCL.BILLWISE.service.BillAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analysis")
@CrossOrigin(origins = "http://localhost:3000")
public class BillAnalysisController {

    @Autowired
    private BillAnalysisService billAnalysisService;

    @GetMapping
    public BillAnalysisResponse getAnalysis() {
        return billAnalysisService.analyzeLatestBill();
    }
}
