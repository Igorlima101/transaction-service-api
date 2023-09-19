package com.transaction.challenge.api.application.exceptions;

public class InsufficientFoundsException extends RuntimeException{

    public InsufficientFoundsException(){
        super("Insufficient founds, operation denied");
    }
}
