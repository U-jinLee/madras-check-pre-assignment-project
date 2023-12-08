package com.example.madrascheck.domain.fileextension.exception;

import com.example.madrascheck.global.error.exception.BusinessException;
import com.example.madrascheck.global.error.exception.ErrorCode;

public class AlreadyExistsFileExtensionException extends BusinessException {

    public AlreadyExistsFileExtensionException() {
        super(ErrorCode.ALREADY_EXISTS_FILE_EXTENSION);
    }

}
