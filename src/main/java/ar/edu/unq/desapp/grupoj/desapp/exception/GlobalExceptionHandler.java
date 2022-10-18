package ar.edu.unq.desapp.grupoj.desapp.exception;

import ar.edu.unq.desapp.grupoj.desapp.exception.cases.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.SignatureException;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ UserNotFoundException.class })
    public ResponseEntity<ApiError> handleUserNotFound(UserNotFoundException ex) {
        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ OfferNotFoundException.class })
    public ResponseEntity<ApiError> handleOfferNotFound(OfferNotFoundException ex) {
        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ TransactionNotFoundException.class })
    public ResponseEntity<ApiError> handleTransactionNotFound(TransactionNotFoundException ex) {
        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ InvalidOfferRequestException.class })
    public ResponseEntity<ApiError> handleInvalidOfferRequestException(InvalidOfferRequestException ex) {
        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ InvalidTransactionRequestException.class })
    public ResponseEntity<ApiError> handleInvalidTransactionRequestException(InvalidTransactionRequestException ex) {
        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ DataIntegrityViolationException.class })
    public ResponseEntity<ApiError> handleDataIntegtityException(DataIntegrityViolationException ex) {
        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST,
                "Incomplete request/Repeated email or crypto address.");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<ApiError> handleDataIntegtityException(MethodArgumentNotValidException ex) {
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, Objects.requireNonNull(ex.getFieldError()).getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<ApiError> handleException(Exception ex) {
        ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        System.out.println(ex.getClass());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
