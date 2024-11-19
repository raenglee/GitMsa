package com.green.orderservice.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(OrderException.class)
    public ResponseEntity<String> orderException(OrderException orderException) {
        return ResponseEntity.badRequest().body(orderException.getMessage());
    }
}
