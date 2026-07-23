package com.APDCL.BILLWISE.service.impl;

import com.APDCL.BILLWISE.entity.MeterReading;
import com.APDCL.BILLWISE.repository.MeterReadingRepository;
import com.APDCL.BILLWISE.service.MeterReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterReadingServiceImpl implements MeterReadingService {

    @Autowired
    private MeterReadingRepository meterReadingRepository;

    @Override
    public MeterReading saveReading(MeterReading reading) {
        return meterReadingRepository.save(reading);
    }

    @Override
    public List<MeterReading> getAllReadings() {
        return meterReadingRepository.findAll();
    }

    @Override
    public MeterReading getReadingById(Long id) {
        return meterReadingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteReading(Long id) {
        meterReadingRepository.deleteById(id);
    }
}
