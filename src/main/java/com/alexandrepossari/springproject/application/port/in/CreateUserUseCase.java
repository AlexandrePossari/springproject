package com.alexandrepossari.springproject.application.port.in;

import com.alexandrepossari.springproject.adapter.out.mysql.entity.UserEntity;
import com.alexandrepossari.springproject.application.domain.User;

import java.util.Optional;

public interface CreateUserUseCase {

    User create(User user);

    User getById(long id);

}
