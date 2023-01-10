package com.project.library.exception;

public class BookDetailsNotFoundException extends RuntimeException{
    public BookDetailsNotFoundException(String message){
        super(message);
    }
}
