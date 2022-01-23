package com.alexandrepossari.springproject.application.service;

import com.alexandrepossari.springproject.adapter.out.mysql.UserRepository;
import com.alexandrepossari.springproject.application.domain.UserEntity;
import com.alexandrepossari.springproject.application.port.in.CreatePostUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreatePostUseCaseService implements CreatePostUseCase {
    private final UserRepository userRepository;

    public CreatePostUseCaseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity create(UserEntity userEntity){
        return userRepository.save(userEntity);
    }
}
