package com.project.library.exception;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException(String message){
        super(message);
    }

}
