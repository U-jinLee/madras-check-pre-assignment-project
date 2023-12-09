package com.example.madrascheck.domain.fileextension.model;

import lombok.Getter;

@Getter
public enum DefaultExtension {
    BAT, CMD, COM, CPL, EXE, SCR, JS;

    public static boolean isDefaultExtension(String name) {

        for(DefaultExtension defaultExtension : DefaultExtension.values()) {
            if(defaultExtension.name().equals(name.toUpperCase())) return true;
        }

        return false;
    }

}