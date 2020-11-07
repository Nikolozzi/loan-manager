package com.gmail.khitirinikoloz.loanmanager.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class LoanManagerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {
        LoanManagerError error = new LoanManagerError(HttpStatus.NOT_FOUND, e);
        return buildResponseEntity(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e) {
        LoanManagerError error = new LoanManagerError(HttpStatus.BAD_REQUEST, "Validation error",
                e.getConstraintViolations().toString());
        return buildResponseEntity(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        LoanManagerError loanManagerError = new LoanManagerError(HttpStatus.INTERNAL_SERVER_ERROR, e);
        return buildResponseEntity(loanManagerError);
    }

    private ResponseEntity<Object> buildResponseEntity(LoanManagerError error) {
        return new ResponseEntity<>(error, error.getStatus());
    }
}
