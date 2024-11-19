package com.green.orderservice.error;

public class OrderException extends RuntimeException {
    public OrderException(String message) {
        super(message);
    }
}
