package com.APDCL.BILLWISE.controller;

import com.APDCL.BILLWISE.dto.BillData;
import com.APDCL.BILLWISE.entity.ElectricityBill;
import com.APDCL.BILLWISE.service.ElectricityBillService;
import com.APDCL.BILLWISE.service.PdfExtractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "http://localhost:5173")
public class ElectricityBillController {

    @Autowired
    private ElectricityBillService electricityBillService;

    @Autowired
    private PdfExtractionService pdfExtractionService;

    // Upload PDF and extract data
    @PostMapping("/upload")
    public BillData uploadPdf(@RequestParam("file") MultipartFile file) throws IOException {
        return pdfExtractionService.extract(file);
    }

    // Save bill manually
    @PostMapping
    public ElectricityBill saveBill(@RequestBody ElectricityBill bill) {
        return electricityBillService.saveBill(bill);
    }

    // Get all bills
    @GetMapping
    public List<ElectricityBill> getAllBills() {
        return electricityBillService.getAllBills();
    }

    // Get latest uploaded bill
    @GetMapping("/latest")
    public ElectricityBill getLatestBill() {
        return electricityBillService.getLatestBill();
    }

    // Get last 6 bills of current consumer
    @GetMapping("/history/{consumerNumber}")
    public List<ElectricityBill> getLast6Bills(
            @PathVariable Long consumerNumber) {

        return electricityBillService.getLast6Bills(consumerNumber);
    }

    // Get bill by ID
    @GetMapping("/{id}")
    public ElectricityBill getBillById(@PathVariable Long id) {
        return electricityBillService.getBillById(id);
    }

    // Delete bill
    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable Long id) {
        electricityBillService.deleteBill(id);
        return "Bill deleted successfully";
    }
}
