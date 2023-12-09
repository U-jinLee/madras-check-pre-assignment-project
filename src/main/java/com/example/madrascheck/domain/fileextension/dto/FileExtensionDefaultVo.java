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

    private Long id;
    private String name;
    private boolean isActive;

    public static FileExtensionDefaultVo from(Long id, DefaultExtension defaultExtension, boolean activation) {
        return new FileExtensionDefaultVo(id, defaultExtension.name().toLowerCase(), activation);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setActivation(boolean activation) {
        this.isActive = activation;
    }

}
