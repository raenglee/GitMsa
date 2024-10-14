package com.example.org.error;

public class JWTAuthException extends RuntimeException {

    public JWTAuthException(String message) {
        super(message);
    }

}