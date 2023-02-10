package ca.usherbrooke.dinf.cs.api.controller.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    ErrorResponse runtimeExceptions(RuntimeException exception) {
        final ErrorResponseException errorResponse = new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR, exception);
        errorResponse.setType(URI.create("https://error.usherbrooke.ca/unknown"));
        return errorResponse;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    ErrorResponse dataIntegrityViolationExceptions(DataIntegrityViolationException exception) {
        final ErrorResponseException errorResponse = new ErrorResponseException(HttpStatus.CONFLICT, exception);
        errorResponse.setType(URI.create("https://error.usherbrooke.ca/conflict"));
        return errorResponse;
    }
}
