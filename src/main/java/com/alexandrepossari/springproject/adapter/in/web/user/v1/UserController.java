package com.alexandrepossari.springproject.adapter.in.web.user.v1;

import com.alexandrepossari.springproject.adapter.in.web.user.v1.exception.InvalidRequestException;
import com.alexandrepossari.springproject.adapter.in.web.user.v1.request.UserRequest;
import com.alexandrepossari.springproject.adapter.in.web.user.v1.response.UserResponse;
import com.alexandrepossari.springproject.application.domain.User;
import com.alexandrepossari.springproject.application.port.in.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final UserControllerRequestValidator userControllerRequestValidator;
    private final UserControllerMapper mapper;

    public UserController(CreateUserUseCase createUserUseCase, UserControllerRequestValidator userControllerRequestValidator, UserControllerMapper mapper) {
        this.createUserUseCase = createUserUseCase;
        this.userControllerRequestValidator = userControllerRequestValidator;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> post(@Valid @RequestBody UserRequest userRequest,
                                             BindingResult bindingResult) {
        checkRequest(bindingResult);
        User user = createUserUseCase.create(mapper.toDomain(userRequest));
        return ResponseEntity.ok(mapper.toResponse(user));
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(userControllerRequestValidator);
    }

    private void checkRequest(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException(bindingResult);
        }
    }
}
