package com.cdog.springboot.di.app.SpringBoot_di.services;

import com.cdog.springboot.di.app.SpringBoot_di.models.Product;
import com.cdog.springboot.di.app.SpringBoot_di.repositories.ProductRepository;
// import com.cdog.springboot.di.app.SpringBoot_di.repositories.ProductRepositoryImpl;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Component //Lo registramos en el contenedor de Spring para poder inyectarlo en otras clases
@Service
public class ProductServiceImpl implements ProductService{

    //private ProductRepositoryImpl repository = new ProductRepositoryImpl(); ya no lo instanciaremos si no que se inyectara automaticamente
    //@Autowired //Se inyecta automaticamente la implementacion de ProductRepository
    private ProductRepository repository;

    @Autowired //Inyectamos el objeto Environment para obtener las configuraciones
    private Environment configuracion;

    public ProductServiceImpl( ProductRepository repository){
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
                    System.out.println(configuracion.getProperty("valores.price.taxeValue", Double.class));
                    Double taxePrice = p.getPrice()* configuracion.getProperty("valores.price.taxeValue", Double.class);
                    //Product newProduct = new Product(p.getId(), p.getName(), taxePrice.longValue()); //Principio de inmutabilidad: se crea un nuevo objeto para no alterar el producto original
                    Product newProduct = (Product) p.clone();
                    newProduct.setPrice(taxePrice.longValue());
//                    p.setPrice(taxePrice.longValue());
//                    return p;
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
        return repository.searchByName(name).stream()
                .map(p->{
                    Double price = p.getPrice() * configuracion.getProperty("valores.price.taxeValue", Double.class);
                    Product newP = (Product) p.clone();
                    newP.setPrice(price.longValue());
                    return newP;
                    }
                ).collect(Collectors.toList());
    }


}
