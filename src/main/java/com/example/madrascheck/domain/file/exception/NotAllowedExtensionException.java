package com.example.madrascheck.domain.file.exception;

import com.example.madrascheck.global.error.exception.BusinessException;
import com.example.madrascheck.global.error.exception.ErrorCode;

public class NotAllowedExtensionException extends BusinessException {

    public NotAllowedExtensionException() {
        super(ErrorCode.NOT_ALLOWED_EXTENSION);
    }

}
