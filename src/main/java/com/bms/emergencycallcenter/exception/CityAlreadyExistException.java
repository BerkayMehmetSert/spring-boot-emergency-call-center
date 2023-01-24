package com.bms.emergencycallcenter.exception;

public class CityAlreadyExistException extends RuntimeException{
    public CityAlreadyExistException(String message) {
        super(message);
    }
}
