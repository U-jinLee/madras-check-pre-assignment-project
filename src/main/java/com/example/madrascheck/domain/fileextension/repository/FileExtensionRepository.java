package com.example.madrascheck.domain.fileextension.repository;

import com.example.madrascheck.domain.fileextension.entity.FileExtension;
import com.example.madrascheck.domain.fileextension.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileExtensionRepository extends JpaRepository<FileExtension, Long> {

    boolean existsByName(String name);

    long countByStatus(Status status);

}