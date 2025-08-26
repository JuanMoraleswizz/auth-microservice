package co.com.pragma.challenge.api;

import co.com.pragma.challenge.api.mapper.UserRestMapper;
import co.com.pragma.challenge.api.request.UserRequest;
import co.com.pragma.challenge.usecase.registeruser.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
private  final RegisterUserUseCase registerUserUseCase;


    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(UserRequest.class)
                .flatMap(userRequest ->
                        registerUserUseCase.execute(UserRestMapper.toDomain(userRequest))
                )
                .flatMap(user ->
                        ServerResponse.ok().bodyValue(user)
                );
    }
}
