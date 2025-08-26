package co.com.pragma.challenge.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRequest {

    private String name;
    @JsonProperty("last_name")
    private String lastName;
    private String email;
    private String phone;
    private String address;
    @JsonProperty("base_salary")
    private Integer baseSalary;
}
