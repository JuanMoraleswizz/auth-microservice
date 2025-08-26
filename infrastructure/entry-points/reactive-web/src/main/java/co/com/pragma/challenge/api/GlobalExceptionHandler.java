package co.com.pragma.challenge.api;

import co.com.pragma.challenge.model.exception.EmailExistException;
import co.com.pragma.challenge.model.exception.EmptyFieldException;
import co.com.pragma.challenge.model.exception.InvalidValueException;
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

    @ExceptionHandler(EmptyFieldException.class)
    public ResponseEntity<Map<String, Object>> handleEmptyFieldException(EmptyFieldException ex) {
        return ResponseEntity.badRequest().body(
                Map.of(
                        "code", ex.getCode(),
                        "message", ex.getMessage()
                )
        );
    }

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(EmailExistException ex) {
        return ResponseEntity.status(400).body(
                Map.of(
                        "code", ex.getCode(),
                        "message", ex.getMessage()
                )
        );
    }

        @ExceptionHandler(InvalidValueException.class)
        public ResponseEntity<Map<String, Object>> handleGenericException(InvalidValueException ex) {
            return ResponseEntity.status(400).body(
                    Map.of(
                            "code", ex.getCode(),
                            "message", ex.getMessage()
                    )
            );
        }
    }


}
