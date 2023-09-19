package com.transaction.challenge.api.application.exceptions;

public class UserTypeException extends RuntimeException{

    public UserTypeException(){
        super("User doesn't have permission for this operation");
    }
}
