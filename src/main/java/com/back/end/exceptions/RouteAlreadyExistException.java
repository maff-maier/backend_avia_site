package com.back.end.exceptions;

public class RouteAlreadyExistException extends Exception{
    
    public RouteAlreadyExistException(String message){
        super(message);
    }
}
