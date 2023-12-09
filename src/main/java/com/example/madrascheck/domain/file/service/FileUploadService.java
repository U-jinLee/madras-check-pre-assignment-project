package com.example.madrascheck.domain.file.service;

import com.example.madrascheck.domain.file.exception.FileIsNullException;
import com.example.madrascheck.domain.file.exception.NotAllowedExtensionException;
import com.example.madrascheck.domain.fileextension.repository.FileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class FileUploadService {

    private final FileExtensionRepository fileExtensionRepository;

    @Transactional
    public void upload(MultipartFile file) {

        if(file == null) throw new FileIsNullException();

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        if(fileExtensionRepository.existsByName(extension))
            throw new NotAllowedExtensionException();
    }
}
