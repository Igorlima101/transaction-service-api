package com.transaction.challenge.api.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerTreatment {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFoundException(
            ResourceNotFoundException exception, HttpServletRequest httpServletRequest){

        String message = "Resource not found";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), message,
                exception.getMessage(), httpServletRequest.getRequestURI());
                return ResponseEntity.status(httpStatus).body(standardError);
    }

    @ExceptionHandler(InsufficientFoundsException.class)
    public ResponseEntity<StandardError> insufficientFoundsException(
            InsufficientFoundsException exception, HttpServletRequest httpServletRequest){

        String message = "Insufficient founds";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), message,
                exception.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(standardError);
    }

    @ExceptionHandler(UserTypeException.class)
    public ResponseEntity<StandardError> userTypeException(
            UserTypeException exception, HttpServletRequest httpServletRequest){

        String message = "Type invalid for this transaction";
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), message,
                exception.getMessage(), httpServletRequest.getRequestURI());
                return ResponseEntity.status(httpStatus).body(standardError);
    }
}
