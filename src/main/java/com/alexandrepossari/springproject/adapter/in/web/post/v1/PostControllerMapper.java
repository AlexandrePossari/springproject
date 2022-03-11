package com.alexandrepossari.springproject.adapter.in.web.post.v1;

import com.alexandrepossari.springproject.adapter.in.web.post.v1.request.PostRequest;
import com.alexandrepossari.springproject.adapter.in.web.post.v1.response.PostResponse;
import com.alexandrepossari.springproject.application.domain.Post;
import com.alexandrepossari.springproject.application.domain.User;
import com.alexandrepossari.springproject.application.port.in.CreateUserUseCase;
import org.springframework.stereotype.Component;

@Component
public class PostControllerMapper {
    private final CreateUserUseCase createUserUseCase;

    public PostControllerMapper(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    public Post toDomain(PostRequest postRequest){
        return  toDomainBuilder(postRequest)
                .build();
    }

    public Post toDomain(long id, PostRequest postRequest){
        return toDomainBuilder(postRequest)
                .id(id)
                .build();
    }

    public PostResponse toResponse(Post post){
        return new PostResponse.Builder()
                .setContent(post.getContent())
                .setId(post.getId())
                .build();
    }

    private Post.Builder toDomainBuilder(PostRequest postRequest) {
        User user = createUserUseCase.getById(postRequest.getUserId());
            return new Post.Builder()
                    .content(postRequest.getContent())
                    .user(user);
    }
}



