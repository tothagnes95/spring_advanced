package com.example.spring_advanced.repositories;

import com.example.spring_advanced.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
    Optional<Post> findByPostId(int id);

}
