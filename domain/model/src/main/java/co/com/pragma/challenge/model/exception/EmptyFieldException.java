package co.com.pragma.challenge.model.exception;


public class EmptyFieldException extends BaseException {
    public EmptyFieldException(String code, String message) {
        super(code, message);
    }

    public EmptyFieldException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
