package com.alexandrepossari.springproject.application.port.in;

import com.alexandrepossari.springproject.adapter.out.mysql.entity.UserEntity;

public interface CreateUserUseCase {

    UserEntity create(UserEntity userEntity);

}
