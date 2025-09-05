package com.carlos.curso.springboot.jpa.springbootjparelationships.repositories;


import com.carlos.curso.springboot.jpa.springbootjparelationships.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
