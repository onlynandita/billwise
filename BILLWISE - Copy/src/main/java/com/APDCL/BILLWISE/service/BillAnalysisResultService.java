package com.APDCL.BILLWISE.service;


import com.APDCL.BILLWISE.entity.BillAnalysisResult;
import java.util.List;

public interface BillAnalysisResultService {

    BillAnalysisResult saveResult(BillAnalysisResult result);

    List<BillAnalysisResult> getAllResults();

    BillAnalysisResult getResultById(Long id);

    void deleteResult(Long id);
}