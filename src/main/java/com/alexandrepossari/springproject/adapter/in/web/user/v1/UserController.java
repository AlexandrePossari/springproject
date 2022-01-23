package com.alexandrepossari.springproject.adapter.in.web.user.v1;

import com.alexandrepossari.springproject.adapter.in.web.user.v1.request.UserLoginRequest;
import com.alexandrepossari.springproject.adapter.in.web.user.v1.request.UserRequest;
import com.alexandrepossari.springproject.adapter.in.web.user.v1.response.UserLoginResponse;
import com.alexandrepossari.springproject.adapter.in.web.user.v1.response.UserResponse;
import com.alexandrepossari.springproject.application.domain.User;
import com.alexandrepossari.springproject.application.domain.UserEntity;
import com.alexandrepossari.springproject.application.port.in.CreatePostUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posts")
public class UserController {
    private final CreatePostUseCase createPostUseCase;

    public UserController(CreatePostUseCase createPostUseCase) {
        this.createPostUseCase = createPostUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> post(@RequestBody UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNome(userRequest.getNome());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setPassword(userRequest.getPassword());


        userEntity = createPostUseCase.create(userEntity);
        UserResponse userResponse = new UserResponse();
        userResponse.setNome(userEntity.getNome());
        userResponse.setEmail(userEntity.getEmail());
        userResponse.setId(userEntity.getId());

        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest){
        User user = new User();
        user.setEmail(userLoginRequest.getEmail());
        user.setPassword(userLoginRequest.getPassword());
    }

}
