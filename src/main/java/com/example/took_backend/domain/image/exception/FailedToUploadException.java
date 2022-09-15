package com.example.took_backend.domain.image.exception;

import com.example.took_backend.global.exception.ErrorCode;
import lombok.Getter;

@Getter
public class FailedToUploadException extends RuntimeException{
    private final ErrorCode errorCode;

    public FailedToUploadException(String message){
        super(message);
        this.errorCode = ErrorCode.FAILED_TO_UPLOAD;
    }
}