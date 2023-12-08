package com.example.madrascheck.domain.fileextension.repository;

import com.example.madrascheck.domain.fileextension.entity.FileExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileExtensionRepository extends JpaRepository<FileExtension, Long> {

    boolean existsByName(String name);

}