package com.cdog.cursospringboot.error.springboot_error.services;

import com.cdog.cursospringboot.error.springboot_error.models.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);

}
