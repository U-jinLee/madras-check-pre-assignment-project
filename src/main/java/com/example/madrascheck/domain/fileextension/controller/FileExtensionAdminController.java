package com.example.madrascheck.domain.fileextension.controller;

import com.example.madrascheck.domain.fileextension.service.FileExtensionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class FileExtensionAdminController {

    private final FileExtensionQueryService fileExtensionQueryService;

    @GetMapping("/file-extension")
    public String fileExtension() {
        fileExtensionQueryService.getFileExtensions();
        return "admin/index";
    }

}
