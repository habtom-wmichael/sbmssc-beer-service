package com.sbmssc.brawerry.app.sbmsscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {


@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex) {
        List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());
        ex.getConstraintViolations().forEach(error -> {
            errorList.add(error.toString());
        });
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
//    @ExceptionHandler(BindException.class)
//    public ResponseEntity<List> validationErrorHandler(BindException ex) {
//        List<String> errors = new ArrayList<>();
//        errors.add(ex.getMessage());
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }