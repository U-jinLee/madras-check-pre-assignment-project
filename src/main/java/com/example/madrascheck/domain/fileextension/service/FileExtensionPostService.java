package com.example.madrascheck.domain.fileextension.service;

import com.example.madrascheck.domain.fileextension.dto.FileExtensionPostDto;
import com.example.madrascheck.domain.fileextension.exception.AlreadyExistsFileExtensionException;
import com.example.madrascheck.domain.fileextension.repository.FileExtensionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FileExtensionPostService {

    private final FileExtensionRepository fileExtensionRepository;

    @Transactional
    public FileExtensionPostDto.Response post(FileExtensionPostDto.Request request) {
        //파일 확장자 중복 검사
        if(fileExtensionRepository.existsByName(request.getName()))
            throw new AlreadyExistsFileExtensionException();

        return FileExtensionPostDto.Response.from(fileExtensionRepository.save(request.toEntity()));
    }

}