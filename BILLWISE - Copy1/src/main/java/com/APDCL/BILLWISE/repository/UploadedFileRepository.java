package com.APDCL.BILLWISE.repository;

import com.APDCL.BILLWISE.entity.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {
}
