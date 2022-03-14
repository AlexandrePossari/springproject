package com.alexandrepossari.springproject.adapter.in.web.user.v1;

import com.alexandrepossari.springproject.adapter.in.web.user.v1.request.UserRequest;
import com.alexandrepossari.springproject.adapter.in.web.user.v1.response.UserResponse;
import com.alexandrepossari.springproject.application.domain.User;
import com.alexandrepossari.springproject.application.port.in.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserControllerMapper mapper;

    public UserController(CreateUserUseCase createUserUseCase, UserControllerMapper mapper) {
        this.createUserUseCase = createUserUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> post(@RequestBody UserRequest userRequest) {
        User user = createUserUseCase.create(mapper.toDomain(userRequest));
        return ResponseEntity.ok(mapper.toResponse(user));
    }


}
