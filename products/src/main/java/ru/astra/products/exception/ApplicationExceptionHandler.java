package ru.astra.products.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.astra.products.dtos.ErrorDto;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ErrorDto("NO STATIC RESOURCE", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(IllegalArgumentException e) {
        return new ResponseEntity<>(new ErrorDto("ILLEGAL ARGUMENT", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
