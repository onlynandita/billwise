package com.APDCL.BILLWISE.controller;

import com.APDCL.BILLWISE.entity.MeterReading;
import com.APDCL.BILLWISE.service.MeterReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meter-readings")
public class MeterReadingController {

    @Autowired
    private MeterReadingService meterReadingService;

    @PostMapping
    public MeterReading saveReading(@RequestBody MeterReading reading) {
        return meterReadingService.saveReading(reading);
    }

    @GetMapping
    public List<MeterReading> getAllReadings() {
        return meterReadingService.getAllReadings();
    }

    @GetMapping("/{id}")
    public MeterReading getReadingById(@PathVariable Long id) {
        return meterReadingService.getReadingById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteReading(@PathVariable Long id) {
        meterReadingService.deleteReading(id);
        return "Meter Reading deleted successfully";
    }
}
