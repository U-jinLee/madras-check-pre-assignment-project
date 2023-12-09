package com.example.madrascheck.domain.fileextension.dto;

import com.example.madrascheck.domain.fileextension.model.DefaultExtension;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileExtensionDefaultVo {

    private String name;
    private boolean isActive;

    public static FileExtensionDefaultVo from(DefaultExtension defaultExtension, boolean activation) {
        return new FileExtensionDefaultVo(defaultExtension.name().toLowerCase(), activation);
    }
    public void setActivation(boolean activation) {
        this.isActive = activation;
    }

}
