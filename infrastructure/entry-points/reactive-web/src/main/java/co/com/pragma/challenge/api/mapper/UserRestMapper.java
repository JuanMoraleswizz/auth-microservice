package co.com.pragma.challenge.api.mapper;

import co.com.pragma.challenge.api.request.UserRequest;
import co.com.pragma.challenge.model.user.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserRestMapper {

    public User toDomain(UserRequest entity) {
        if (entity == null) return null;
        return new User(
                entity.getName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getAddress(),
                entity.getBaseSalary()
        );
    }
}
