package com.alexandrepossari.springproject.adapter.out.mysql.repository;

import com.alexandrepossari.springproject.adapter.out.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
