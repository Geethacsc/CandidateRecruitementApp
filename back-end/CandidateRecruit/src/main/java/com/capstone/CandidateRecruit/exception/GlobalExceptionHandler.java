package com.capstone.CandidateRecruit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=CustomUserException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody ErrorResponse userException(CustomUserException ex){
        System.out.println("inside user exception handler");
        return new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),ex.getMessage());
    }

    @ExceptionHandler(value=NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorResponse nullPointerException(NullPointerException ex){
        System.out.println("inside null pinter exception handler");
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
    }
}
