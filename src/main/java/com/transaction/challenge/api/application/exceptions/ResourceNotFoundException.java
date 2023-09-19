package com.transaction.challenge.api.application.exceptions;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not found with id: " + id);
    }
}
