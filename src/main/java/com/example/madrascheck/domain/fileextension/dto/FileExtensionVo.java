package com.example.madrascheck.domain.fileextension.dto;

import com.example.madrascheck.domain.fileextension.entity.FileExtension;

public record FileExtensionVo(long id, String name) {

    public static FileExtensionVo from(FileExtension fileExtension) {
        return new FileExtensionVo(fileExtension.getId(), fileExtension.getName());
    }

}
