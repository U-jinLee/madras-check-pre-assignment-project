package com.example.madrascheck.domain.fileextension.controller;

import com.example.madrascheck.domain.fileextension.dto.FileExtensionPostDto;
import com.example.madrascheck.domain.fileextension.service.FileExtensionPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/file-extensions")
@RestController
public class FileExtensionApiController {

    private final FileExtensionPostService fileExtensionPostService;

    /**
     * 파일 확장자 등록
     *
     * @exception com.example.madrascheck.domain.fileextension.exception.AlreadyExistsFileExtensionException 파일 확장자가 이미 존재할 경우
     * @author yoojin Lee
     */
    @PostMapping
    public ResponseEntity<FileExtensionPostDto.Response> postFileExtension(@RequestBody
                                                                           @Valid
                                                                           FileExtensionPostDto.Request request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fileExtensionPostService.post(request));
    }

}