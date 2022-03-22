package com.alexandrepossari.springproject.adapter.out.mysql;

import com.alexandrepossari.springproject.adapter.out.mysql.repository.UserRepository;
import com.alexandrepossari.springproject.application.domain.User;
import com.alexandrepossari.springproject.application.port.out.UserRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryPortService implements UserRepositoryPort {

    private final UserRepository repository;
    private final UserRepositoryMapper mapper;

    public UserRepositoryPortService(UserRepository repository, UserRepositoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public User save(User user) {
        var entity = repository.save(mapper.toEntity(user));
        return mapper.toDomain(entity);
    }

    @Override
    public Optional<User> findById(long id) {
        var userOp = repository.findById(id);
        if (userOp.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(mapper.toDomain(userOp.get()));
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        var userOp = repository.findByEmail(email);
        if (userOp.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.toDomain(userOp.get()));
    }

}
