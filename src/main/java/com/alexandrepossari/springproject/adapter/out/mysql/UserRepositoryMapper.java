package com.alexandrepossari.springproject.adapter.out.mysql;

import com.alexandrepossari.springproject.adapter.out.mysql.entity.UserEntity;
import com.alexandrepossari.springproject.application.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserRepositoryMapper {
    public UserEntity toEntity(User user) {
        return new UserEntity.Builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .nome(user.getNome())
                .build();
    }

    public User toDomain(UserEntity user) {
        return new User.Builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .nome(user.getNome())
                .build();
    }

}
