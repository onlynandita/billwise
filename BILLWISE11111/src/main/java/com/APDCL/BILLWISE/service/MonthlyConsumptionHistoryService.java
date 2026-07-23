package com.APDCL.BILLWISE.service;

import com.APDCL.BILLWISE.entity.MonthlyConsumptionHistory;
import java.util.List;

public interface MonthlyConsumptionHistoryService {

    MonthlyConsumptionHistory saveHistory(MonthlyConsumptionHistory history);

    List<MonthlyConsumptionHistory> getAllHistory();

    MonthlyConsumptionHistory getHistoryById(Long id);

    void deleteHistory(Long id);
}
