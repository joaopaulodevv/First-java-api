package com.joaopaulodevv.firstapi.exception;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex){
        return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse(404,ex.getMessage(),LocalDateTime.now()));
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> EmailAlreadyExists(EmailAlreadyExistsException ex){
        return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse(400,ex.getMessage(),LocalDateTime.now()));
    }

    
}
