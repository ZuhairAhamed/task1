package com.example.Task01.exceptionhandler;

import com.example.Task01.model.EmployeeResponseModel;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeResponseExceptionHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EmployeeResponseModel idNotFound(){
        return new EmployeeResponseModel("Id is not found in the DB");
    }
}
