package com.example.took_backend.global.exception.handler;

import com.example.took_backend.global.exception.ErrorCode;
import com.example.took_backend.global.exception.ErrorResponse;
import com.example.took_backend.global.exception.exceptionCollection.TokenExpirationException;
import com.example.took_backend.global.exception.exceptionCollection.TokenNotVaildException;
import com.example.took_backend.global.exception.exceptionCollection.UserNotFoundException;
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

    @ExceptionHandler()
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e){
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

    @ExceptionHandler(TokenExpirationException.class)
    public ResponseEntity<ErrorResponse> handleTokenExpirationException(HttpServletRequest request, TokenExpirationException e) {
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

    @ExceptionHandler(TokenNotVaildException.class)
    public ResponseEntity<ErrorResponse> handleTokenNotValidException(HttpServletRequest request, TokenNotVaildException e) {
        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }

    private void printError(HttpServletRequest request, RuntimeException ex, String message) {
        log.error(request.getRequestURI());
        log.error(message);
        ex.printStackTrace();
    }
}
