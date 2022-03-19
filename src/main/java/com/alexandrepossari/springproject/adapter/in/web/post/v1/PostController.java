package com.alexandrepossari.springproject.adapter.in.web.post.v1;

import com.alexandrepossari.springproject.adapter.in.web.post.v1.request.PostRequest;
import com.alexandrepossari.springproject.adapter.in.web.post.v1.response.PostResponse;
import com.alexandrepossari.springproject.adapter.in.web.user.v1.exception.InvalidRequestException;
import com.alexandrepossari.springproject.application.domain.Post;
import com.alexandrepossari.springproject.application.domain.User;
import com.alexandrepossari.springproject.application.port.in.CreatePostUseCase;
import com.alexandrepossari.springproject.application.port.in.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    private final CreatePostUseCase createPostUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final PostControllerMapper mapper;
    private final PostControllerRequestValidator postControllerRequestValidator;

    public PostController(CreatePostUseCase createPostUseCase, CreateUserUseCase createUserUseCase, PostControllerMapper mapper, PostControllerRequestValidator postControllerRequestValidator) {
        this.createPostUseCase = createPostUseCase;
        this.createUserUseCase = createUserUseCase;
        this.mapper = mapper;
        this.postControllerRequestValidator = postControllerRequestValidator;
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@Valid @RequestBody PostRequest postRequest,
                                                   BindingResult bindingResult){
        checkRequest(bindingResult);
        Post post = createPostUseCase.create(mapper.toDomain(postRequest));
        return ResponseEntity.ok(mapper.toResponse(post));
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(postControllerRequestValidator);
    }

    private void checkRequest(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InvalidRequestException(bindingResult);
        }
    }

}
