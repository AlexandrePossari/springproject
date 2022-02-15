package com.alexandrepossari.springproject.adapter.out.mysql.repository;

import com.alexandrepossari.springproject.adapter.out.mysql.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity , Long> {
}
