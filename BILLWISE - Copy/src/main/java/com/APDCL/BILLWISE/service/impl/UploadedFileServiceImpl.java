package com.APDCL.BILLWISE.service.impl;

import com.APDCL.BILLWISE.entity.UploadedFile;
import com.APDCL.BILLWISE.repository.UploadedFileRepository;
import com.APDCL.BILLWISE.service.UploadedFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadedFileServiceImpl implements UploadedFileService {

    @Autowired
    private UploadedFileRepository uploadedFileRepository;

    @Override
    public UploadedFile saveFile(UploadedFile file) {
        return uploadedFileRepository.save(file);
    }

    @Override
    public List<UploadedFile> getAllFiles() {
        return uploadedFileRepository.findAll();
    }

    @Override
    public UploadedFile getFileById(Long id) {
        return uploadedFileRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFile(Long id) {
        uploadedFileRepository.deleteById(id);
    }
}
