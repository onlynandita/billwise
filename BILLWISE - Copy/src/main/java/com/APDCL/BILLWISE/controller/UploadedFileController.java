package com.APDCL.BILLWISE.controller;

import com.APDCL.BILLWISE.entity.UploadedFile;
import com.APDCL.BILLWISE.service.UploadedFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/uploaded-files")
@CrossOrigin(origins = "http://localhost:3000")
public class UploadedFileController {

    @Autowired
    private UploadedFileService uploadedFileService;

    @PostMapping
    public UploadedFile saveFile(@RequestBody UploadedFile file) {
        return uploadedFileService.saveFile(file);
    }

    @GetMapping
    public List<UploadedFile> getAllFiles() {
        return uploadedFileService.getAllFiles();
    }

    @GetMapping("/{id}")
    public UploadedFile getFileById(@PathVariable Long id) {
        return uploadedFileService.getFileById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteFile(@PathVariable Long id) {
        uploadedFileService.deleteFile(id);
        return "File deleted successfully";
    }

    @PostMapping("/upload")
    public UploadedFile uploadPdf(@RequestParam("file") MultipartFile file) throws IOException {

        String uploadDir = "C:/BillWiseUploads/saved";

        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = uploadDir + file.getOriginalFilename();

        file.transferTo(new File(filePath));

        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setFileName(file.getOriginalFilename());
        uploadedFile.setFileType(file.getContentType());
        uploadedFile.setFileSize(file.getSize());
        uploadedFile.setUploadDate(LocalDate.now().toString());
        uploadedFile.setFilePath(filePath);

        return uploadedFileService.saveFile(uploadedFile);
    }
}
