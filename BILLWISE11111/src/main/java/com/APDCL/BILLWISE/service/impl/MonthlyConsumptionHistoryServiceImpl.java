package com.APDCL.BILLWISE.service.impl;

import com.APDCL.BILLWISE.entity.MonthlyConsumptionHistory;
import com.APDCL.BILLWISE.repository.MonthlyConsumptionHistoryRepository;
import com.APDCL.BILLWISE.service.MonthlyConsumptionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthlyConsumptionHistoryServiceImpl implements MonthlyConsumptionHistoryService {

    @Autowired
    private MonthlyConsumptionHistoryRepository monthlyConsumptionHistoryRepository;

    @Override
    public MonthlyConsumptionHistory saveHistory(MonthlyConsumptionHistory history) {
        return monthlyConsumptionHistoryRepository.save(history);
    }

    @Override
    public List<MonthlyConsumptionHistory> getAllHistory() {
        return monthlyConsumptionHistoryRepository.findAll();
    }

    @Override
    public MonthlyConsumptionHistory getHistoryById(Long id) {
        return monthlyConsumptionHistoryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteHistory(Long id) {
        monthlyConsumptionHistoryRepository.deleteById(id);
    }
}
