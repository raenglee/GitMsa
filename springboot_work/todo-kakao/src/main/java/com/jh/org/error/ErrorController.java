package com.jh.org.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleMyException(UserException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("error/my-error");
    }
}