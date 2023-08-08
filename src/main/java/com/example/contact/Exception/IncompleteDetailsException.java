package com.example.contact.Exception;

public class IncompleteDetailsException extends  RuntimeException{
    private String message;

    public IncompleteDetailsException(String message) {
        super(message);
        this.message = message;
    }
}
