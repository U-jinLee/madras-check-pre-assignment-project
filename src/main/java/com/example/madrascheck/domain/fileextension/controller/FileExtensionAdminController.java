package com.example.madrascheck.domain.fileextension.controller;

import com.example.madrascheck.domain.fileextension.dto.FileExtensionsGetDto;
import com.example.madrascheck.domain.fileextension.service.FileExtensionQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class FileExtensionAdminController {

    private final FileExtensionQueryService fileExtensionQueryService;

    @GetMapping
    public String fileExtension(Model model) {
        FileExtensionsGetDto.Response result = fileExtensionQueryService.getFileExtensions();
        model.addAttribute("count", result.getCount());
        model.addAttribute("defaultExtensions", result.getDefaultExtensions());
        model.addAttribute("customerExtensions", result.getCustomExtensions());
        return "index";
    }

}
