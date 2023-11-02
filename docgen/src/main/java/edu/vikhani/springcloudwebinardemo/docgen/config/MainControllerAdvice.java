package edu.vikhani.springcloudwebinardemo.docgen.config;

import edu.vikhani.springcloudwebinardemo.docgen.exception.ClientInfoNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainControllerAdvice {
    @ExceptionHandler(ClientInfoNotFound.class)
    public ResponseEntity<String> handleClientInfoNotFound(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
