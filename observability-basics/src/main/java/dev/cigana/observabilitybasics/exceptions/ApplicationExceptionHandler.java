package dev.cigana.observabilitybasics.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({DomainBaseException.class})
    public ResponseEntity<ErrorResponse> baseException(DomainBaseException exception){
        ErrorResponse er = new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(er);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ErrorResponse> constraintViolatonException(ConstraintViolationException exception){
        ErrorResponse er = new ErrorResponse(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        return ResponseEntity.badRequest().body(er);
    }

}
