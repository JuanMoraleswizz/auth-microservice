package co.com.pragma.challenge.model.exception;

public class InvalidValueException extends BaseException{

    public InvalidValueException(String code, String message) {
        super(code, message);
    }

    public InvalidValueException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
