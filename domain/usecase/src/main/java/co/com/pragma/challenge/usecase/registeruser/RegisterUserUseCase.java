package co.com.pragma.challenge.usecase.registeruser;

import co.com.pragma.challenge.model.exception.EmailExistException;
import co.com.pragma.challenge.model.exception.codes.ExceptionCode;
import co.com.pragma.challenge.model.user.User;
import co.com.pragma.challenge.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class RegisterUserUseCase {
    public static final String THIS_EMAIL_ALREADY_EXISTS_MESSAGE = "This email already exists";
    private final UserRepository userRepository;

    public Mono<User> execute(User user) {
        return userRepository.existsByEmail(user.getEmail())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new EmailExistException(ExceptionCode.EMAIL_EXIST, THIS_EMAIL_ALREADY_EXISTS_MESSAGE));
                    }
                    return userRepository.saveUser(user);
                });
    }

}
