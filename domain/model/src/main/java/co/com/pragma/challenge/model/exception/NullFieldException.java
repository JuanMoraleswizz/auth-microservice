package co.com.pragma.challenge.model.exception;

public class NullFieldException extends BaseException {
    public NullFieldException(String code, String message) {
        super(code, message);
    }

    public NullFieldException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
