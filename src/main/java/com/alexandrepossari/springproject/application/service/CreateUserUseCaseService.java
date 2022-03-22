package com.alexandrepossari.springproject.application.service;

import com.alexandrepossari.springproject.application.domain.User;
import com.alexandrepossari.springproject.application.exception.EntityAlreadyRegisteredException;
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
        validateEmailAlreadyRegistered(user.getEmail());
        return repositoryPort.save(user);
    }

    @Override
    public User getById(long id) {
        return repositoryPort.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ErrorReason.USER_NOT_FOUND));
    }

    private void validateEmailAlreadyRegistered(String email) throws EntityAlreadyRegisteredException {
        if (repositoryPort.findUserByEmail(email).isPresent()) {
            throw new EntityAlreadyRegisteredException(ErrorReason.USER_EMAIL_ALREADY_REGISTERED);
        }
    }

}
