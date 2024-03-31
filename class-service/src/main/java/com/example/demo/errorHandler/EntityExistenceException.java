package com.example.demo.errorHandler;

public class EntityExistenceException extends RuntimeException{
    public EntityExistenceException(String message){
        super(message);
    }
}
