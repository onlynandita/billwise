package com.APDCL.BILLWISE.repository;

import com.APDCL.BILLWISE.entity.ElectricityBill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectricityBillRepository extends JpaRepository<ElectricityBill, Long> {

    // Latest uploaded bill
    ElectricityBill findTopByOrderByIdDesc();

    // Duplicate check
    List<ElectricityBill> findByConsumerNumberAndStatementMonth(
            Long consumerNumber,
            String statementMonth
    );

    // Last 6 bills of the current consumer
    List<ElectricityBill> findTop6ByConsumerNumberOrderByIdDesc(
            Long consumerNumber
    );

}


