package com.example.demo.rest.advice;

import com.example.demo.validation.exceptions.BusinessValidationException;
import com.example.demo.validation.exceptions.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(BusinessValidationException.class)
    public ResponseEntity<HttpMessage> handleRequestBusinessExceptions(BusinessValidationException ex){
        HttpMessage errorMessage=ex.getErrorMessage();
        return new ResponseEntity(errorMessage.getMessage(),ex.getStatus());
    }
    public ResponseEntity<HttpMessage> handleRequestBodyNotValidExceptions(MethodArgumentNotValidException ex){
        FieldError fieldError = ex.getBindingResult().getFieldError();
        String message = "Field -" + fieldError.getField() + "- " + fieldError.getDefaultMessage();
        return new ResponseEntity(new HttpMessage(message), HttpStatus.BAD_REQUEST);
    }
}
