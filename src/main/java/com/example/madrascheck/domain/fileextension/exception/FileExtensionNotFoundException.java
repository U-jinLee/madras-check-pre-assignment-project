package com.example.madrascheck.domain.fileextension.exception;

import com.example.madrascheck.global.error.exception.BusinessException;
import com.example.madrascheck.global.error.exception.ErrorCode;

public class FileExtensionNotFoundException extends BusinessException {
    public FileExtensionNotFoundException() {
        super(ErrorCode.FILE_EXTENSION_NOT_FOUND);
    }
}
