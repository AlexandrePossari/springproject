package com.alexandrepossari.springproject.adapter.out.mysql;

import com.alexandrepossari.springproject.application.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
