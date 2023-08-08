package com.example.contact.Exception;

public class UserAlreadyExistException extends RuntimeException{

    private String message;

    public UserAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
