package com.example.madrascheck.domain.fileextension.service;


import com.example.madrascheck.domain.fileextension.dto.FileExtensionVo;
import com.example.madrascheck.domain.fileextension.dto.FileExtensionsGetDto;
import com.example.madrascheck.domain.fileextension.entity.FileExtension;
import com.example.madrascheck.domain.fileextension.model.Status;
import com.example.madrascheck.domain.fileextension.repository.FileExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FileExtensionQueryService {

    private final FileExtensionRepository fileExtensionRepository;

    @Transactional(readOnly = true)
    public FileExtensionsGetDto.Response getFileExtensions() {
        List<FileExtension> extensions = fileExtensionRepository.findAll();

        return FileExtensionsGetDto.Response.from(
                getFileExtensionVos(extensions, Status.DEFAULT), getFileExtensionVos(extensions, Status.CUSTOM));
    }

    private List<FileExtensionVo> getFileExtensionVos(List<FileExtension> extensions, Status status) {
        return extensions.stream().filter(extension -> extension.getStatus().equals(status))
                .map(FileExtensionVo::from).toList();
    }
}