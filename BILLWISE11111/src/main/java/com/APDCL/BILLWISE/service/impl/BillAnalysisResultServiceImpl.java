package com.APDCL.BILLWISE.service.impl;

import com.APDCL.BILLWISE.entity.BillAnalysisResult;
import com.APDCL.BILLWISE.repository.BillAnalysisResultRepository;
import com.APDCL.BILLWISE.service.BillAnalysisResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillAnalysisResultServiceImpl implements BillAnalysisResultService {

    @Autowired
    private BillAnalysisResultRepository billAnalysisResultRepository;

    @Override
    public BillAnalysisResult saveResult(BillAnalysisResult result) {
        return billAnalysisResultRepository.save(result);
    }

    @Override
    public List<BillAnalysisResult> getAllResults() {
        return billAnalysisResultRepository.findAll();
    }

    @Override
    public BillAnalysisResult getResultById(Long id) {
        return billAnalysisResultRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteResult(Long id) {
        billAnalysisResultRepository.deleteById(id);
    }
}