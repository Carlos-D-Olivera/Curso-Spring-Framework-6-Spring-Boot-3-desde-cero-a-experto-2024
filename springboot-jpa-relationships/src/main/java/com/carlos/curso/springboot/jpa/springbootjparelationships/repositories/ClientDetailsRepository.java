package com.carlos.curso.springboot.jpa.springbootjparelationships.repositories;

import com.carlos.curso.springboot.jpa.springbootjparelationships.entities.ClientDetails;
import org.springframework.data.repository.CrudRepository;

public interface ClientDetailsRepository extends CrudRepository<ClientDetails, Long> {
}
