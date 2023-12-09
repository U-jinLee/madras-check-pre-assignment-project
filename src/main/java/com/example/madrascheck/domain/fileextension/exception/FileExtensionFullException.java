package com.example.madrascheck.domain.fileextension.exception;

import com.example.madrascheck.global.error.exception.BusinessException;
import com.example.madrascheck.global.error.exception.ErrorCode;

public class FileExtensionFullException extends BusinessException {
    public FileExtensionFullException() {
        super(ErrorCode.FILE_EXTENSION_FULL);
    }
}
