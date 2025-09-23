package com.carlos.curso.springboot.app.springbootcrud.services;

import com.carlos.curso.springboot.app.springbootcrud.entities.Product;
import com.carlos.curso.springboot.app.springbootcrud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            Product productBd = productOptional.orElseThrow();
            productBd.setName(product.getName());
            productBd.setDescription(product.getDescription());
            productBd.setPrice(product.getPrice());

            return Optional.of(productRepository.save(productBd));
        }

        return productOptional;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productDb = productRepository.findById(id);

        productDb.ifPresent(prod ->{
            productRepository.delete(prod);
        });

        return productDb;
    }
}
