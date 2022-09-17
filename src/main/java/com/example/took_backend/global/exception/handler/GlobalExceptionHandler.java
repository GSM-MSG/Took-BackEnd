package com.example.took_backend.global.exception.handler;

import com.example.took_backend.domain.auth.exception.EmailAlreadyExistException;
import com.example.took_backend.domain.auth.exception.NotVerifyEmailException;
import com.example.took_backend.domain.auth.exception.PasswordWrongExceptin;
import com.example.took_backend.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.took_backend.domain.email.exception.AuthCodeExpiredException;
import com.example.took_backend.domain.email.exception.AuthCodeMismatchException;
import com.example.took_backend.domain.email.exception.ManyRequestEmailAuthException;
import com.example.took_backend.domain.image.exception.FailedToUploadException;
import com.example.took_backend.domain.user.exception.CardNotFoundException;
import com.example.took_backend.domain.user.exception.UserNotFoundException;
import com.example.took_backend.global.exception.ErrorCode;
import com.example.took_backend.global.exception.ErrorResponse;
import com.example.took_backend.global.exception.exceptionCollection.TokenExpirationException;
import com.example.took_backend.global.exception.exceptionCollection.TokenNotVaildException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthCodeExpiredException.class)
    public ResponseEntity<ErrorResponse> DuplicateMemberExceptionHandler(HttpServletRequest request, AuthCodeExpiredException ex) {
        printError(request, ex, ex.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().getMessage(), ex.getErrorCode().getStatus());
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
    @ExceptionHandler(TokenExpirationException.class)
    public ResponseEntity<ErrorResponse> handleTokenExpirationException(HttpServletRequest request, TokenExpirationException ex) {
        printError(request, ex, ex.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().getMessage(), ex.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler(TokenNotVaildException.class)
    public ResponseEntity<ErrorResponse> handleTokenNotValidException(HttpServletRequest request, TokenNotVaildException ex) {
        printError(request, ex, ex.getErrorCode().getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode().getMessage(), ex.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }
    @ExceptionHandler(ManyRequestEmailAuthException.class)
    public ResponseEntity<ErrorResponse> ManyRequestEmailAuthException (ManyRequestEmailAuthException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> UserNotFoundException (UserNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }
    @ExceptionHandler(AuthCodeMismatchException.class)
    public ResponseEntity<ErrorResponse> AuthCodeMisMatchException (AuthCodeMismatchException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<ErrorResponse> CardNotFoundException (CardNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(FailedToUploadException.class)
    public ResponseEntity<ErrorResponse> FailedToUploadException (FailedToUploadException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> EmailAlreadyExist(EmailAlreadyExistException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(NotVerifyEmailException.class)
    public ResponseEntity<ErrorResponse> NotVerifyEmail(NotVerifyEmailException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }

    @ExceptionHandler(PasswordWrongExceptin.class)
    public ResponseEntity<ErrorResponse> PasswordWrong(PasswordWrongExceptin exceptin) {
        ErrorResponse errorResponse = new ErrorResponse(exceptin.getErrorCode().getMessage(), exceptin.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exceptin.getErrorCode().getStatus()));
    }
    @ExceptionHandler(RefreshTokenNotFoundException.class)
    public ResponseEntity<ErrorResponse> RefreshTokenNotFoundException(RefreshTokenNotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode().getMessage(), exception.getErrorCode().getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getErrorCode().getStatus()));
    }
    private void printError(HttpServletRequest request, RuntimeException ex, String message) {
        log.error(request.getRequestURI());
        log.error(message);
        ex.printStackTrace();
    }
}
