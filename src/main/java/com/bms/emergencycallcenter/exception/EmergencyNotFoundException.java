package com.bms.emergencycallcenter.exception;

public class EmergencyNotFoundException extends RuntimeException{
    public EmergencyNotFoundException(String message) {
        super(message);
    }
}
