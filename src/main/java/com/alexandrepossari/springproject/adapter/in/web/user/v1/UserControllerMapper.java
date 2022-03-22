package com.alexandrepossari.springproject.adapter.in.web.user.v1;

import com.alexandrepossari.springproject.adapter.in.web.post.v1.response.PostResponse;
import com.alexandrepossari.springproject.adapter.in.web.user.v1.request.UserRequest;
import com.alexandrepossari.springproject.adapter.in.web.user.v1.response.UserResponse;
import com.alexandrepossari.springproject.application.domain.Post;
import com.alexandrepossari.springproject.application.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserControllerMapper {

    public User toDomain(UserRequest userRequest) {
        return toDomainBuilder(userRequest)
                .build();
    }

    public User toDomain(long id, UserRequest userRequest) {
        return toDomainBuilder(userRequest)
                .id(id)
                .build();
    }

    public UserResponse toResponse(User user) {
        return new UserResponse.Builder()
                .setEmail(user.getEmail())
                .setNome(user.getNome())
                .setId(user.getId())
                .build();
    }

    private User.Builder toDomainBuilder(UserRequest userRequest) {
        return new User.Builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .nome(userRequest.getNome());
    }
}
