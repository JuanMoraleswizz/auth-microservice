package co.com.pragma.challenge.api;

import co.com.pragma.challenge.api.error.ErrorResponse;
import co.com.pragma.challenge.model.exception.EmailExistException;
import co.com.pragma.challenge.model.exception.EmptyFieldException;
import co.com.pragma.challenge.model.exception.InvalidValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailExistException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleEmailExistException(EmailExistException ex) {

        ErrorResponse response = new ErrorResponse(
                ex.getCode(),
                ex.getMessage()
        );

        return Mono.just(ResponseEntity
                .badRequest()
                .body(response));
    }

    @ExceptionHandler(EmptyFieldException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleEmptyFieldException(EmptyFieldException ex) {
        ErrorResponse response = new ErrorResponse(
                ex.getCode(),
                ex.getMessage()
        );
        return Mono.just(ResponseEntity.badRequest()
                .body(response));
    }

    @ExceptionHandler(InvalidValueException.class)
    public Mono<ResponseEntity<ErrorResponse>> handleGenericException(InvalidValueException ex) {
         ErrorResponse response = new ErrorResponse(
                 ex.getCode(),
                ex.getMessage()
        );
        return Mono.just(ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response));
    }

}
