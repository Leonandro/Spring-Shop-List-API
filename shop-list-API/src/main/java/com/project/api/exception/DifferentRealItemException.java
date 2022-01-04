package com.project.api.exception;

public class DifferentRealItemException extends  RuntimeException{
    public DifferentRealItemException(String message) {
        super(message);
    }

    public DifferentRealItemException(String message, Throwable cause) {
        super(message, cause);
    }
}
