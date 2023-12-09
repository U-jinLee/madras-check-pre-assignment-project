package com.example.madrascheck.domain.fileextension.dto;

import com.example.madrascheck.domain.fileextension.entity.FileExtension;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileExtensionVo {

    private long id;
    private String name;

    public static FileExtensionVo from(FileExtension fileExtension) {
        return new FileExtensionVo(fileExtension.getId(), fileExtension.getName());
    }

}
