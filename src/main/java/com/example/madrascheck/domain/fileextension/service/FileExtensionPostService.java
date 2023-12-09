package com.example.madrascheck.domain.fileextension.service;

import com.example.madrascheck.domain.fileextension.dto.FileExtensionPostDto;
import com.example.madrascheck.domain.fileextension.entity.FileExtension;
import com.example.madrascheck.domain.fileextension.exception.AlreadyExistsFileExtensionException;
import com.example.madrascheck.domain.fileextension.exception.FileExtensionFullException;
import com.example.madrascheck.domain.fileextension.model.DefaultExtension;
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
        //검사
        validate(request);
        //기본확장자 검사 및 저장
        FileExtension fileExtension =
                DefaultExtension.isDefaultExtension(request.getName()) ? request.toDefaultEntity() : request.toCustomEntity();

        return FileExtensionPostDto.Response.from(fileExtensionRepository.save(fileExtension));
    }

    private void validate(FileExtensionPostDto.Request request) {
        //파일 확장자 개수 검사
        if(fileExtensionRepository.count() >= 200) throw new FileExtensionFullException();
        //파일 확장자 중복 검사
        if(fileExtensionRepository.existsByName(request.getName()))
            throw new AlreadyExistsFileExtensionException();
    }

}