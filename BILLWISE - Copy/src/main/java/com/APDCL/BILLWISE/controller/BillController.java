package com.APDCL.BILLWISE.controller;

import com.APDCL.BILLWISE.dto.BillData;
import com.APDCL.BILLWISE.service.PdfExtractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/bill")
@CrossOrigin(origins = "*")
public class BillController {

    @Autowired
    private PdfExtractionService pdfExtractionService;

    @PostMapping("/upload")
    public ResponseEntity<BillData> uploadBill(
            @RequestParam("file") MultipartFile file) throws IOException {

        BillData billData = pdfExtractionService.extract(file);

        return ResponseEntity.ok(billData);
    }
}