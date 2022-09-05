package com.example.took_backend.global.exception.handler;

import com.example.took_backend.domain.email.exception.AuthCodeExpiredException;
import com.example.took_backend.global.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.net.BindException;

@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthCodeExpiredException.class)
    public ResponseEntity<ErrorResponse> DuplicateMemberExceptionHandler(HttpServletRequest request, AuthCodeExpiredException ex){
        printError(request, ex, ex.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().isSuccess(), ex.getErrorCode().getMessage(), ex.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    /*
    이거 나중에 예외처리 살리기
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
        return ErrorResponse()
    }
    */

    private void printError(HttpServletRequest request, RuntimeException ex, String message) {
        log.error(request.getRequestURI());
        log.error(message);
        ex.printStackTrace();
    }
}