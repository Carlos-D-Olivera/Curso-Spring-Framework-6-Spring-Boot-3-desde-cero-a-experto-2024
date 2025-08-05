package org.colivera.curso.springboot.error.springbooterror.services;

import org.colivera.curso.springboot.error.springbooterror.domain.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findById(Long id);
}
