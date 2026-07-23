package com.APDCL.BILLWISE.service.impl;

import com.APDCL.BILLWISE.entity.Billnsight;
import com.APDCL.BILLWISE.repository.BillnsightRepository;
import com.APDCL.BILLWISE.service.BillnsightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillnsightServiceImpl implements BillnsightService {

    @Autowired
    private BillnsightRepository billnsightRepository;

    @Override
    public Billnsight saveInsight(Billnsight nsight) {
        return billnsightRepository.save(nsight);
    }

    @Override
    public List<Billnsight> getAllInsights() {
        return billnsightRepository.findAll();
    }

    @Override
    public Billnsight getInsightById(Long id) {
        return billnsightRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInsight(Long id) {
        billnsightRepository.deleteById(id);
    }
}
