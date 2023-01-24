package com.bms.emergencycallcenter.exception;

public class EmergencyAlreadyExistException extends RuntimeException{
    public EmergencyAlreadyExistException(String message) {
        super(message);
    }
}
