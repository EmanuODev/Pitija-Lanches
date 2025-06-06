package com.ecommerc.backend.exceptions;

public class ResponseExceptionDTO extends RuntimeException {
    public ResponseExceptionDTO (String message) {
        super(message);
    }
}
