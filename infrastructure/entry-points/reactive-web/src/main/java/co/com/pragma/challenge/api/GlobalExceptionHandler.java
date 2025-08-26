package co.com.pragma.challenge.api;

import co.com.pragma.challenge.model.exception.EmailExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<Map<String, Object>> handleEmailExistException(EmailExistException ex) {
        return ResponseEntity.badRequest().body(
                Map.of(
                        "code", ex.getCode(),
                        "message", ex.getMessage()
                )
        );
    }


}
