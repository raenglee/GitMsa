package com.green.orderservice.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(CatalogException.class)
    public ResponseEntity<String> orderException(CatalogException catalogException) {
        return ResponseEntity.badRequest().body(catalogException.getMessage());
    }
}
