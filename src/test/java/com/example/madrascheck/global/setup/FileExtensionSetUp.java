package com.example.madrascheck.global.setup;

import com.example.madrascheck.domain.fileextension.entity.FileExtension;
import com.example.madrascheck.domain.fileextension.model.Status;
import com.example.madrascheck.domain.fileextension.repository.FileExtensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileExtensionSetUp {

    @Autowired
    FileExtensionRepository fileExtensionRepository;

    public FileExtension save() {
        return fileExtensionRepository.save(buildFileExtension());
    }

    private FileExtension buildFileExtension() {
        return FileExtension.builder()
                .name("test")
                .status(Status.CUSTOM)
                .build();
    }

}
