package com.example.madrascheck.domain.fileextension.controller;

import com.example.madrascheck.domain.fileextension.dto.FileExtensionPostDto;
import com.example.madrascheck.domain.fileextension.service.FileExtensionDeleteService;
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
    private final FileExtensionDeleteService fileExtensionDeleteService;

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

    /**
     * 파일 확장자 삭제
     *
     * @exception com.example.madrascheck.domain.fileextension.exception.FileExtensionNotFoundException 파일 확장자가 존재하지 않을 경우
     * @author yoojin Lee
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFileExtension(@PathVariable("id") long id) {
        fileExtensionDeleteService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}