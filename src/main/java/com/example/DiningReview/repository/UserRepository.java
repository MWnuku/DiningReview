package com.example.DiningReview.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.DiningReview.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String name);

    Optional<User> findById(Long id);

    List<User> findAll();
}