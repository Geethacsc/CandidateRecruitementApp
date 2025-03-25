package com.capstone.CandidateRecruit.exception;

public class CustomUserException extends RuntimeException{

    private String message;

    public CustomUserException(){

    }
    public CustomUserException(String message){
        super(message);
        System.out.println("inside CustomUserException");
        this.message=message;
    }
}
