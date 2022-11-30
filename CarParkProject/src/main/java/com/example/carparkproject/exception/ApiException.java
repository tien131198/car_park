package com.example.carpark.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiException {
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage toDo(){
        return new ErrorMessage(500,"id not valid");
    }
}
