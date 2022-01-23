package com.alexandrepossari.springproject.application.port.in;

import com.alexandrepossari.springproject.application.domain.UserEntity;

public interface CreatePostUseCase {

    UserEntity create(UserEntity userEntity);

}
