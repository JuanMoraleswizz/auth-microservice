package co.com.pragma.challenge.model.shared;

import co.com.pragma.challenge.model.exception.EmptyFieldException;
import co.com.pragma.challenge.model.exception.InvalidValueException;
import co.com.pragma.challenge.model.exception.NullFieldException;
import co.com.pragma.challenge.model.exception.codes.ExceptionCode;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Mono;

@UtilityClass
public class ValidateArgument {

    public void validateNotNull(Object object, String message) {
        if (object == null) {
            Mono.error(new NullFieldException(ExceptionCode.NULL_FIELD, message));
        }
    }

    public void validateStringNotEmpty(String string, String message) {
        if (string == null || string.isEmpty()) {
            Mono.error(new EmptyFieldException(ExceptionCode.EMPTY_FIELD, message));
        }
    }

    public void validateRange(int number, int min, int max, String message) {
        if (number < min || number > max) {
            Mono.error(new InvalidValueException(ExceptionCode.INVALID_VALUE ,message));
        }
    }
}
