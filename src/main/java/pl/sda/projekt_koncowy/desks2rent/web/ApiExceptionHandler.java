package pl.sda.projekt_koncowy.desks2rent.web;

import org.aspectj.apache.bcel.classfile.annotation.RuntimeAnnos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<String> handleError(RuntimeException ex) {
        return ResponseEntity
                .status(422)
                .body(ex.getMessage());
    }
}
