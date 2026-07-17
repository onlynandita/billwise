package com.APDCL.BILLWISE.entity;

import jakarta.persistence.*;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@Entity
@Table(name="uploaded_file")

public class UploadedFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;

    private String fileType;

    private Long fileSize;

    private String uploadDate;

    private String filePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ElectricityBill getElectricityBill() {
        return electricityBill;
    }

    public void setElectricityBill(ElectricityBill electricityBill) {
        this.electricityBill = electricityBill;
    }

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private ElectricityBill electricityBill;


}
