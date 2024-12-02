package com.green.catalogservice.error;

public class CatalogException extends RuntimeException {
    public CatalogException(String message) {
        super(message);
    }
}
