package com.alexandrepossari.springproject.application.port.out;

import com.alexandrepossari.springproject.application.domain.User;

import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);

    Optional<User> findById(long id);

    Optional<User> findUserByEmail(String email);

}
