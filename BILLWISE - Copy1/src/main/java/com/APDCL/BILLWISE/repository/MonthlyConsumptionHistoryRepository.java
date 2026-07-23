package com.APDCL.BILLWISE.repository;

import com.APDCL.BILLWISE.entity.MonthlyConsumptionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthlyConsumptionHistoryRepository extends JpaRepository<MonthlyConsumptionHistory, Long> {
}


