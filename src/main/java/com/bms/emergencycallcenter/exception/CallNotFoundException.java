package com.bms.emergencycallcenter.exception;

public class CallNotFoundException extends RuntimeException{
    public CallNotFoundException(String message) {
        super(message);
    }
}
