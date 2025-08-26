package co.com.pragma.challenge.model.user;
import co.com.pragma.challenge.model.shared.ValidateArgument;
import lombok.Builder;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder(toBuilder = true)
public class User {
    private static final String NAME_IS_REQUIRED_MESSAGE = "Name is required";
    private static final String LAST_NAME_IS_REQUIRED_MESSAGE = "Last name is required";
    private static final String EMAIL_IS_REQUIRED_MESSAGE = "Email is required";
    private static final String BASE_SALARY_IS_REQUIRED_MESSAGE = "Base salary is required";
    private static final int MIN_BASE_SALARY = 0;
    private static final int MAX_BASE_SALARY = 15000000;
    private static final String VALIDATE_SALARY_BASE_MESSAGE =
            "Base salary must be between " + MIN_BASE_SALARY + " and " + MAX_BASE_SALARY;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Integer baseSalary;

    public User(String name, String lastName, String email, String phone, String address, int baseSalary) {

        ValidateArgument.validateStringNotEmpty(name, NAME_IS_REQUIRED_MESSAGE);
        ValidateArgument.validateStringNotEmpty(lastName, LAST_NAME_IS_REQUIRED_MESSAGE);
        ValidateArgument.validateStringNotEmpty(email, EMAIL_IS_REQUIRED_MESSAGE);
        ValidateArgument.validateNotNull(baseSalary, BASE_SALARY_IS_REQUIRED_MESSAGE);
        ValidateArgument.validateRange(baseSalary, MIN_BASE_SALARY, MAX_BASE_SALARY, VALIDATE_SALARY_BASE_MESSAGE);
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.baseSalary = baseSalary;
    }

}
