package mk.ukim.finki.wp.lab1b.web.handler;

import mk.ukim.finki.wp.lab1b.model.exception.HostNotFoundException;
import mk.ukim.finki.wp.lab1b.web.controller.AccommodationController;
import mk.ukim.finki.wp.lab1b.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice(assignableTypes = AccommodationController.class)
public class AccommodationControllerExceptionHandler {
    @ExceptionHandler(HostNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(HostNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
