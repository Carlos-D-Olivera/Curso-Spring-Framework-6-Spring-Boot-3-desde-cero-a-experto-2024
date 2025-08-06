package org.colivera.curso.springboot.error.springbooterror.services;

import org.colivera.curso.springboot.error.springbooterror.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private List<User> users;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
//        User user = null;
//
//        for(User u : this.users){
//            if(u.getId().equals(id)){
//                user = u;
//                break;
//            }
//        }

        //Se Optimiza
        Optional<User> user = this.users.stream()
                .filter( //Agregamos un filtro
                        u -> u.getId().equals(id) //Filtramos usuarios que tengan el mismo Id
                )
                .findFirst(); //Se toma el primero que encuentre

        return user;
    }
}
