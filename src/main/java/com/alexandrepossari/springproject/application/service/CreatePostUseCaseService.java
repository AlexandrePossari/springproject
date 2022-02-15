package com.alexandrepossari.springproject.application.service;

import com.alexandrepossari.springproject.application.domain.Post;
import com.alexandrepossari.springproject.application.port.in.CreatePostUseCase;
import com.alexandrepossari.springproject.application.port.out.PostRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreatePostUseCaseService implements CreatePostUseCase {
    private final PostRepositoryPort postRepositoryPort;

    public CreatePostUseCaseService(PostRepositoryPort postRepositoryPort) {
        this.postRepositoryPort = postRepositoryPort;
    }

    @Override
    public Post create(Post post) {
        return postRepositoryPort.create(post);
    }
}
