package com.alexandrepossari.springproject.application.port.in;

import com.alexandrepossari.springproject.adapter.out.mysql.entity.PostEntity;
import com.alexandrepossari.springproject.application.domain.Post;

public interface CreatePostUseCase {
    Post create(Post post);
}
