package com.carlos.curso.springboot.app.springbootcrud.services;

import com.carlos.curso.springboot.app.springbootcrud.entities.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User save(User user);
}
