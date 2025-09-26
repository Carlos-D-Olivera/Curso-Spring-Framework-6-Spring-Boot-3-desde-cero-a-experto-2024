package com.carlos.curso.springboot.app.springbootcrud.repositories;

import com.carlos.curso.springboot.app.springbootcrud.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
