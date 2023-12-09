package com.example.madrascheck.domain.fileextension.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileExtensionsGetDto {

    @ToString
    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {

        private long count;
        private List<FileExtensionDefaultVo> defaultExtensions = new ArrayList<>();
        private List<FileExtensionVo> customExtensions = new ArrayList<>();

        public static Response from(List<FileExtensionDefaultVo> defaultExtensions, List<FileExtensionVo> customExtensions) {
            return new Response(customExtensions.size(), defaultExtensions, customExtensions);
        }

    }

}