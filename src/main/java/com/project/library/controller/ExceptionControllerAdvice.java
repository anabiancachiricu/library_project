package com.project.library.controller;

import com.project.library.exception.AddressNotFoundException;
import com.project.library.exception.WrongIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler({AddressNotFoundException.class, SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<String> handleAddressNotFound(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    /*
    @ExceptionHandler({WrongIdException.class, SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<String> handleWrongId(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(exception.getMessage());
    }*/

   /* @ExceptionHandler({AuthorNotFoundException.class, SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<String> handleAuthorNotFound(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler({BookDetailsNotFoundException.class, SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<String> handleBookDetailsNotFound(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    */

    @ExceptionHandler
    public ResponseEntity<String> handleInvalidField(MethodArgumentNotValidException exception){
        System.out.println(exception.getMessage());
        String invalidFields = "Invalid fields: \n"
                + exception.getBindingResult().getFieldErrors().stream()
                .map(e -> "Field: " + e.getField() + ", error: " + e.getDefaultMessage() + ", value: " + e.getRejectedValue())
                .collect(Collectors.joining("\n"));
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .body(invalidFields);
    }


}