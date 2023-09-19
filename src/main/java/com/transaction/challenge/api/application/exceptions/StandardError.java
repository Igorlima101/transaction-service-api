package com.transaction.challenge.api.application.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
public class StandardError {

    private Instant timestamp;
    private Integer status;
    private String message;
    private String error;
    private String path;

    public StandardError(Instant timestamp, Integer status, String message, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
    }
}
