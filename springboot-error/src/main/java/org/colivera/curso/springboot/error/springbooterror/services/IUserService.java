package org.colivera.curso.springboot.error.springbooterror.services;

import org.colivera.curso.springboot.error.springbooterror.domain.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();

    Optional<User> findById(Long id);
}
