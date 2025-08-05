package org.colivera.curso.springboot.error.springbooterror.services;

import org.colivera.curso.springboot.error.springbooterror.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    private List<User> users;

    public UserServiceImpl(){
        this.users = new ArrayList<>();
        this.users.add(new User(1L, "Carlos", "Olivera"));
        this.users.add(new User(2L, "David", "Guzman"));
        this.users.add(new User(3L, "Maria", "Perez"));
        this.users.add(new User(4L, "Josefa", "Martinez"));
        this.users.add(new User(5L, "Ale", "Gutierrez"));

    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User findById(Long id) {
        User user = null;

        for(User u : this.users){
            if(u.getId().equals(id)){
                user = u;
                break;
            }
        }

        return user;
    }
}
