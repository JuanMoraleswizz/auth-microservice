package co.com.pragma.challenge.model.exception;

public class EmailExistException extends BaseException{
    public EmailExistException(String code, String message) {
        super(code, message);
    }

    public EmailExistException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
