package com.cdog.cursospringboot.error.springboot_error.services;

import com.cdog.cursospringboot.error.springboot_error.models.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<>();
        this.users.add(new User(1L, "Jhon", "Doe"));
        this.users.add(new User(2L, "Andres", "Perez"));
        this.users.add(new User(3L, "Josefa", "Ramirez"));
        this.users.add(new User(4L, "Allen", "Gutierrez"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        for(User u: this.users){
            if(id.equals(u.getId())){
                user = u;
                return user;
            }
        }

        return user;
    }
}
