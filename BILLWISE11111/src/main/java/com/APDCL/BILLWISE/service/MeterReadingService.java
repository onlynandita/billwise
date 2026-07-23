package com.APDCL.BILLWISE.service;

import com.APDCL.BILLWISE.entity.MeterReading;
import java.util.List;

public interface MeterReadingService {

    MeterReading saveReading(MeterReading reading);

    List<MeterReading> getAllReadings();

    MeterReading getReadingById(Long id);

    void deleteReading(Long id);
}
