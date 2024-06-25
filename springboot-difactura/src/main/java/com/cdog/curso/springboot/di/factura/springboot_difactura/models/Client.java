package com.cdog.curso.springboot.di.factura.springboot_difactura.models;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

@Component
//@SessionScope //El cliente pertenecera a la sesion
//@ApplicationScope //Es parecido al singleton pero este es un poco mas amplio Los componentes anotados con esta anotacion seran una misma instancia dentro de una sola aplicacion de spring. muy poco usado
@RequestScope
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Client {

    @Value("${client.name}")
    private String name;
    @Value("${client.lastname}")
    private String lastname;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
