package co.com.pragma.challenge.model.exception.codes;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionCode {
    public final String NULL_FIELD = "ERR-001";
    public final String EMPTY_FIELD = "ERR-002";
    public final String INVALID_VALUE = "ERR-003";
    public final String EMAIL_EXIST = "ERR-004";
}
