package com.APDCL.BILLWISE.service;

import com.APDCL.BILLWISE.entity.Billnsight;
import java.util.List;

public interface BillnsightService {

    Billnsight saveInsight(Billnsight insight);

    List<Billnsight> getAllInsights();

    Billnsight getInsightById(Long id);

    void deleteInsight(Long id);
}
