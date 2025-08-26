package co.com.pragma.challenge.r2dbc;

import co.com.pragma.challenge.model.user.User;
import co.com.pragma.challenge.model.user.gateways.UserRepository;
import co.com.pragma.challenge.r2dbc.entity.UserEntity;
import co.com.pragma.challenge.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public class UserRepositoryAdapter extends ReactiveAdapterOperations<
        User,
        UserEntity,
        Long,
        UserReactiveRepository
> implements UserRepository {
    public UserRepositoryAdapter(UserReactiveRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, User.class));
    }

    @Override
    public Mono<User> saveUser(User user) {
        return super.save(user);
    }

    @Override
    public Mono<Boolean> existsByEmail(String email) {
       return repository.findByEmail(email)
                .hasElement();
    }
}
