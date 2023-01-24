package com.bms.emergencycallcenter.exception;

public class AlertedServiceNotFoundException extends RuntimeException{
    public AlertedServiceNotFoundException(String message) {
        super(message);
    }
}
