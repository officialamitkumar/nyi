package com.lenscart.productms.controller;

import com.lenscart.productms.exceptions.InvalidProductDataException;
import com.lenscart.productms.exceptions.InvalidProductTypeException;
import com.lenscart.productms.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class CentralizedExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public String handleNotFound(ProductNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ InvalidProductTypeException.class, InvalidProductDataException.class,
            ConstraintViolationException.class, MethodArgumentNotValidException.class })
    public String handleInvalid(Exception ex) {
        return ex.getMessage();
    }
}
