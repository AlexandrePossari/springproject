package com.alexandrepossari.springproject.adapter.in.web.post.v1;

import com.alexandrepossari.springproject.adapter.in.web.post.v1.request.PostRequest;
import com.alexandrepossari.springproject.adapter.in.web.post.v1.response.PostResponse;
import com.alexandrepossari.springproject.adapter.out.mysql.entity.PostEntity;
import com.alexandrepossari.springproject.adapter.out.mysql.entity.UserEntity;
import com.alexandrepossari.springproject.application.domain.Post;
import com.alexandrepossari.springproject.application.domain.User;
import com.alexandrepossari.springproject.application.port.in.CreatePostUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    private final CreatePostUseCase createPostUseCase;

    public PostController(CreatePostUseCase createPostUseCase) {
        this.createPostUseCase = createPostUseCase;
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest){

        User user = new User();
        user.setId(postRequest.getUserId());
        Post post = new Post();
        post.setContent(postRequest.getContent());
        post.setUser(user);
        post = createPostUseCase.create(post);

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(post.getContent());
        postResponse.setId(post.getId());

        return ResponseEntity.ok(postResponse);

    }
}
