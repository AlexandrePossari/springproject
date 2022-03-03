package com.alexandrepossari.springproject.application.port.out;

import com.alexandrepossari.springproject.adapter.out.mysql.entity.PostEntity;
import com.alexandrepossari.springproject.application.domain.Post;

import java.util.Optional;

public interface PostRepositoryPort {
    Post create(Post post);

}
