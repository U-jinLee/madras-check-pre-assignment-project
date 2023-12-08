package com.example.madrascheck.domain.fileextension.service;

import com.example.madrascheck.domain.fileextension.entity.FileExtension;
import com.example.madrascheck.domain.fileextension.exception.FileExtensionNotFoundException;
import com.example.madrascheck.domain.fileextension.repository.FileExtensionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FileExtensionDeleteService {

    private final FileExtensionRepository fileExtensionRepository;

    @Transactional
    public void delete(long id) {
        FileExtension fileExtension = fileExtensionRepository.findById(id)
                .orElseThrow(FileExtensionNotFoundException::new);

        fileExtensionRepository.delete(fileExtension);
    }

}
