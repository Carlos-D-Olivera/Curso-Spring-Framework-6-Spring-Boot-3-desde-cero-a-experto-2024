package com.cdog.springboot.di.app.SpringBoot_di.services;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;
import com.cdog.springboot.di.app.SpringBoot_di.repositories.ProductRepository;
// import com.cdog.springboot.di.app.SpringBoot_di.repositories.ProductRepositoryImpl;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Component //Lo registramos en el contenedor de Spring para poder inyectarlo en otras clases
@Service //Se marca como un servicio (Logica de negocio)
public class ProductServiceImpl implements ProductService{

    //private ProductRepositoryImpl repository = new ProductRepositoryImpl(); ya no lo instanciaremos si no que se inyectara automaticamente
    //@Autowired //Se inyecta automaticamente la implementacion de ProductRepository
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productFoo") ProductRepository repository){
        this.repository = repository;
    }

//    @Autowired //Inyeccion mediante el metodo set
//    public void setRepository(ProductRepository repository) {
//        this.repository = repository;
//    }


    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(
                p -> {
                    Double taxePrice = p.getPrice()*1.25d;
                    //Product newProduct = new Product(p.getId(), p.getName(), taxePrice.longValue()); //Principio de inmutabilidad: se crea un nuevo objeto para no alterar el producto original
                    Product newProduct = (Product) p.clone();
                    newProduct.setPrice(taxePrice.longValue());
                    return newProduct;
                }
                ).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

    @Override
    public List<Product> findByName(String name){
        return repository.searchByName(name);
    }


}
