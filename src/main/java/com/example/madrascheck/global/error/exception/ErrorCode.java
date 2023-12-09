package com.example.madrascheck.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    // Common
    INVALID_INPUT_VALUE(400, "C001", "Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "C002", " Invalid Input Value"),
    ENTITY_NOT_FOUND(400, "C003", " Entity Not Found"),
    INTERNAL_SERVER_ERROR(500, "C004", "Server Error"),
    INVALID_TYPE_VALUE(400, "C005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(403, "C006", "Access is Denied"),

    // FileExtension
    ALREADY_EXISTS_FILE_EXTENSION(HttpStatus.BAD_REQUEST.value(), "FE001", "이미 존재하는 파일 확장자입니다"),
    FILE_EXTENSION_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "FE002", "존재하지 않는 파일 확장자입니다"),
    FILE_EXTENSION_FULL(HttpStatus.BAD_REQUEST.value(), "FE003", "제한할 수 있는 파일 확장자는 200개를 넘을 수 없습니다"),
    // File
    NOT_ALLOWED_EXTENSION(HttpStatus.BAD_REQUEST.value(), "F001", "허용되지 않는 파일 확장자입니다"),
    FILE_IS_NULL(HttpStatus.BAD_REQUEST.value(), "F002", "파일이 비었습니다");

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}
