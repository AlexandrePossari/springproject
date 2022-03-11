package com.alexandrepossari.springproject.adapter.in.web.post.v1;

import com.alexandrepossari.springproject.adapter.in.web.post.v1.request.PostRequest;
import com.alexandrepossari.springproject.adapter.in.web.post.v1.response.PostResponse;
import com.alexandrepossari.springproject.application.domain.Post;
import com.alexandrepossari.springproject.application.domain.User;
import com.alexandrepossari.springproject.application.port.in.CreatePostUseCase;
import com.alexandrepossari.springproject.application.port.in.CreateUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    private final CreatePostUseCase createPostUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final PostControllerMapper mapper;

    public PostController(CreatePostUseCase createPostUseCase, CreateUserUseCase createUserUseCase, PostControllerMapper mapper) {
        this.createPostUseCase = createPostUseCase;
        this.createUserUseCase = createUserUseCase;
        this.mapper = mapper;
    }


    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest){
        Post post = createPostUseCase.create(mapper.toDomain(postRequest));
        return ResponseEntity.ok(mapper.toResponse(post));
    }

}
