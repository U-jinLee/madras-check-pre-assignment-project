package com.example.madrascheck.domain.fileextension.dto;

import com.example.madrascheck.domain.fileextension.entity.FileExtension;
import com.example.madrascheck.domain.fileextension.model.Status;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileExtensionPostDto {

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Request {

        @NotEmpty(message = "파일 확장자를 입력해주세요")
        @Size(min = 1, max = 20, message = "파일 확장자는 1자 이상 20자 이하로 입력해주세요")
        private String name;

        @NotNull(message = "파일 확장자의 상태를 입력해주세요")
        private Status status;

        public static Request of(String name, Status status) {
            return new Request(name, status);
        }

        public FileExtension toEntity() {
            return FileExtension.builder()
                    .name(name)
                    .status(status)
                    .build();
        }

    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {

        private long id;
        private String name;
        private Status status;

        public static Response from(FileExtension fileExtension) {
            return new Response(fileExtension.getId(), fileExtension.getName(), fileExtension.getStatus());
        }

    }

}