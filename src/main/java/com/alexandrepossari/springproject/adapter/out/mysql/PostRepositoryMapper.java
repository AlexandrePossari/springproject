package com.alexandrepossari.springproject.adapter.out.mysql;

import com.alexandrepossari.springproject.adapter.out.mysql.entity.PostEntity;
import com.alexandrepossari.springproject.adapter.out.mysql.entity.UserEntity;
import com.alexandrepossari.springproject.application.domain.Post;
import com.alexandrepossari.springproject.application.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostRepositoryMapper {

    private final UserRepositoryMapper mapper;

    public PostRepositoryMapper(UserRepositoryMapper mapper) {
        this.mapper = mapper;
    }

    public PostEntity toEntity(Post post) {
        return new PostEntity.Builder()
                .content(post.getContent())
                .id(post.getId())
                .userEntity(mapper.toEntity(post.getUser()))
                .build();
    }

    public Post toDomain(PostEntity post) {
        return new Post.Builder()
                .content(post.getContent())
                .id(post.getId())
                .user(mapper.toDomain(post.getUserEntity()))
                .build();
    }

}
