package com.cdog.curso.springboot.di.factura.springboot_difactura.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //Anotamos la factura como componente
public class Invoice {

    @Autowired //Inyectamos el cliente automaticamente ya que este esta anotado como component
    private Client client;

    @Value("${invoice.description}")
    private String description;

    //@Bean Un objeto list no se puede anotar con @bean ya que es una clase de Java
    @Autowired 
    private List<Item> items;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
