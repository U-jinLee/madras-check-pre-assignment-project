package com.example.madrascheck.domain.fileextension.service;


import com.example.madrascheck.domain.fileextension.dto.FileExtensionDefaultVo;
import com.example.madrascheck.domain.fileextension.dto.FileExtensionVo;
import com.example.madrascheck.domain.fileextension.dto.FileExtensionsGetDto;
import com.example.madrascheck.domain.fileextension.entity.FileExtension;
import com.example.madrascheck.domain.fileextension.model.DefaultExtension;
import com.example.madrascheck.domain.fileextension.model.Status;
import com.example.madrascheck.domain.fileextension.repository.FileExtensionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class FileExtensionQueryService {

    private final FileExtensionRepository fileExtensionRepository;

    @Transactional(readOnly = true)
    public FileExtensionsGetDto.Response getFileExtensions() {
        List<FileExtension> extensions = fileExtensionRepository.findAll();


        List<FileExtensionDefaultVo> defaultVos =
                Arrays.stream(DefaultExtension.values()).map(extension -> FileExtensionDefaultVo.from(extension, false)).toList();

        defaultVos.forEach(defaultVo ->
            getFileExtensionVos(extensions, Status.DEFAULT).stream()
                    .filter(extension -> extension.getName().equals(defaultVo.getName()))
                    .findFirst().ifPresent(extension -> defaultVo.setActivation(true))
        );

        return FileExtensionsGetDto.Response.from(
                defaultVos, getFileExtensionVos(extensions, Status.CUSTOM));
    }

    private List<FileExtensionVo> getFileExtensionVos(List<FileExtension> extensions, Status status) {
        return extensions.stream().filter(extension -> extension.getStatus().equals(status))
                .map(FileExtensionVo::from).toList();
    }
}