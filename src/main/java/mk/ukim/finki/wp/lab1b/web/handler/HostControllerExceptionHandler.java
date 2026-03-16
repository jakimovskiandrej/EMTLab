package mk.ukim.finki.wp.lab1b.web.handler;

import mk.ukim.finki.wp.lab1b.model.exception.CountryNotFoundException;
import mk.ukim.finki.wp.lab1b.web.controller.HostController;
import mk.ukim.finki.wp.lab1b.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = HostController.class)
public class HostControllerExceptionHandler {
    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(CountryNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
