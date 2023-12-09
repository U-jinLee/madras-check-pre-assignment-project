package com.example.madrascheck.domain.file.exception;

import com.example.madrascheck.global.error.exception.BusinessException;
import com.example.madrascheck.global.error.exception.ErrorCode;

public class FileIsNullException extends BusinessException {


    public FileIsNullException() {
        super(ErrorCode.FILE_IS_NULL);
    }
}
