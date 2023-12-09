package com.example.madrascheck.domain.fileextension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class FileExtensionAdminController {

    @GetMapping("/file-extension")
    public String fileExtension() {
        return "admin/index";
    }

}
