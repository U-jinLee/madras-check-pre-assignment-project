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

    public void saveList() {
        fileExtensionRepository.save(buildFileExtension("bat", Status.DEFAULT));
        fileExtensionRepository.save(buildFileExtension("cmd", Status.DEFAULT));
        fileExtensionRepository.save(buildFileExtension("com", Status.DEFAULT));
        fileExtensionRepository.save(buildFileExtension("sh", Status.CUSTOM));
        fileExtensionRepository.save(buildFileExtension("ju", Status.CUSTOM));
        fileExtensionRepository.save(buildFileExtension("ch", Status.CUSTOM));
    }

    public FileExtension save() {
        return fileExtensionRepository.save(buildFileExtension());
    }

    private FileExtension buildFileExtension(String name, Status status) {
        return FileExtension.builder()
                .name(name)
                .status(status)
                .build();
    }

    private FileExtension buildFileExtension() {
        return FileExtension.builder()
                .name("test")
                .status(Status.CUSTOM)
                .build();
    }

}
