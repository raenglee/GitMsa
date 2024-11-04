package com.green.userservice.error;

public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
