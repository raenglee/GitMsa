package com.green.userservice.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> userException(UserException userException) {
        return ResponseEntity.badRequest().body(userException.getMessage());
    }
}
