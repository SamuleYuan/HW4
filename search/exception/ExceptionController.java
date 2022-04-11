package com.example.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = NotfoundException.class)
    public ResponseEntity<Object> exception(NotfoundException exception) {
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }
}
