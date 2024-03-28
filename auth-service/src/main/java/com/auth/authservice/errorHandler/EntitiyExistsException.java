package com.auth.authservice.errorHandler;

public class EntitiyExistsException extends RuntimeException {
    public EntitiyExistsException(String message) {
        super(message);
    }
    
}
