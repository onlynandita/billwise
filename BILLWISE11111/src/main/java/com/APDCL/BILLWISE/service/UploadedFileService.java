package com.APDCL.BILLWISE.service;

import com.APDCL.BILLWISE.entity.UploadedFile;
import java.util.List;

public interface UploadedFileService {

    UploadedFile saveFile(UploadedFile file);

    List<UploadedFile> getAllFiles();

    UploadedFile getFileById(Long id);

    void deleteFile(Long id);
}
