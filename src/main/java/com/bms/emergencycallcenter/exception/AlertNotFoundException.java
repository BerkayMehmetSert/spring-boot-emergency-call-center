package com.bms.emergencycallcenter.exception;

public class AlertNotFoundException extends RuntimeException{
    public AlertNotFoundException(String message) {
        super(message);
    }
}
