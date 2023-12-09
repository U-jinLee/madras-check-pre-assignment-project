package com.example.madrascheck.domain.file.controller;

import com.example.madrascheck.domain.file.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/files")
@RestController
public class FileApiController {

    private final FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity<Object> uploadFile(MultipartFile file) {
        fileUploadService.upload(file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}