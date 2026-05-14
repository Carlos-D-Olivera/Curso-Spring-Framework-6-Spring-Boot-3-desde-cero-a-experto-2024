package com.carlos.curso.springboot.backend.backendproducts.repositories;

import com.carlos.curso.springboot.backend.backendproducts.products.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "products")
public interface ProductRepository extends CrudRepository<Product, Long> {

}
