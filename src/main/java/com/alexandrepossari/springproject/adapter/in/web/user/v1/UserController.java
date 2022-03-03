package com.alexandrepossari.springproject.adapter.in.web.user.v1;

import com.alexandrepossari.springproject.adapter.in.web.user.v1.request.UserRequest;
import com.alexandrepossari.springproject.adapter.in.web.user.v1.response.UserResponse;
import com.alexandrepossari.springproject.adapter.out.mysql.entity.UserEntity;
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

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> post(@RequestBody UserRequest userRequest){
        User user = new User();
        user.setNome(userRequest.getNome());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());


        user = createUserUseCase.create(user);
        UserResponse userResponse = new UserResponse();
        userResponse.setNome(user.getNome());
        userResponse.setEmail(user.getEmail());
        userResponse.setId(user.getId());

        return ResponseEntity.ok(userResponse);
    }


}
