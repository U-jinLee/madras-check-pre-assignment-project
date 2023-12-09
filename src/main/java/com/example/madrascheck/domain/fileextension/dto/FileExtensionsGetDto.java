package com.example.madrascheck.domain.fileextension.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileExtensionsGetDto {

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {

        private List<FileExtensionVo> defaultExtensions = new ArrayList<>();
        private List<FileExtensionVo> customExtensions = new ArrayList<>();

        public static Response from(List<FileExtensionVo> defaultNames, List<FileExtensionVo> customNames) {
            return new Response(defaultNames, customNames);
        }

    }

}