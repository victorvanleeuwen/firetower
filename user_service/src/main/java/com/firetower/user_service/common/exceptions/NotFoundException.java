package com.firetower.user_service.common.exceptions;

public class NotFoundException extends RuntimeException {


    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
