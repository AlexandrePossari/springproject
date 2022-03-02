package com.alexandrepossari.springproject.application.service;

import com.alexandrepossari.springproject.application.domain.User;
import com.alexandrepossari.springproject.application.exception.EntityNotFoundException;
import com.alexandrepossari.springproject.application.exception.ErrorReason;
import com.alexandrepossari.springproject.application.port.in.CreateUserUseCase;
import com.alexandrepossari.springproject.application.port.out.UserRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseService implements CreateUserUseCase {
    private final UserRepositoryPort repositoryPort;

    public CreateUserUseCaseService(UserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public User create(User user){
        return repositoryPort.save(user);
    }

    @Override
    public User getById(long id) {
        return repositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorReason.USER_NOT_FOUND));
    }


}
