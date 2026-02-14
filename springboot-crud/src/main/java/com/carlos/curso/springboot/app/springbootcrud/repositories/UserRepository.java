package com.carlos.curso.springboot.app.springbootcrud.repositories;

import com.carlos.curso.springboot.app.springbootcrud.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
