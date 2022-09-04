package com.example.took_backend.global.exception.handler;

import com.example.took_backend.global.exception.ErrorResponse;
import com.example.took_backend.global.exception.TookException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;

@RestControllerAdvice
@Slf4j
public class TookExceptionHandler {
    @ExceptionHandler(TookException.class)
    public ResponseEntity<ErrorResponse> handleTookException(TookException e){
        log.info("code : '{}''", e.getErrorCode());
       return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestDataException(MethodArgumentNotValidException e){
        log.error("handleInvalidRequestDataException throw MethodArgumentNotValidException");
        BindingResult result = e.getBindingResult();
        StringBuilder builder = new StringBuilder();

        for (FieldError fieldError : result.getFieldErrors()) {
            builder.append(fieldError.getField()).append(":");
            builder.append(fieldError.getDefaultMessage());
            builder.append(",");
        }
        builder.deleteCharAt(builder.lastIndexOf(","));
        return ErrorResponse.toResponseEntity(HttpStatus.BAD_REQUEST, builder.toString());
    }
}
