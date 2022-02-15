package com.alexandrepossari.springproject.adapter.out.mysql;

import com.alexandrepossari.springproject.adapter.out.mysql.entity.PostEntity;
import com.alexandrepossari.springproject.adapter.out.mysql.entity.UserEntity;
import com.alexandrepossari.springproject.adapter.out.mysql.repository.PostRepository;
import com.alexandrepossari.springproject.application.domain.Post;
import com.alexandrepossari.springproject.application.port.out.PostRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class PostRepositoryPortService implements PostRepositoryPort {
    private final PostRepository postRepository;

    public PostRepositoryPortService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post create(Post post) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(post.getUser().getId());

        PostEntity postEntity = new PostEntity();
        postEntity.setContent(post.getContent());
        postEntity.setUserEntity(userEntity);
        postEntity = postRepository.save(postEntity);

        post.setId(postEntity.getId());

        return post;
    }
}
