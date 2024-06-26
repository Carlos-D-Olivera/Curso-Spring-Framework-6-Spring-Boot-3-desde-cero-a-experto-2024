package com.cdog.curso.springboot.di.factura.springboot_difactura.models;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //Anotamos la factura como componente
public class Invoice {

    @Autowired //Inyectamos el cliente automaticamente ya que este esta anotado como component
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    //@Bean Un objeto list no se puede anotar con @bean ya que es una clase de Java
    @Autowired
    @Qualifier("default")
    private List<Item> items;

    public Invoice(){
        System.out.println("Creando el componente de la factura");
        System.out.println(this.client);
        System.out.println(this.description);
    }

    @PostConstruct //@PostConstruct: esta anotacion sirve para ejecutar un metodo despues de instanciar el objeto
    public void init(){
        System.out.println("Creando el componente de la factura");
        this.client.setName(this.client.getName().concat(" Pepe"));
        this.setDescription(description.concat(" del Cliente: ").concat(client.getName()).concat(" ").concat(client.getLastname()));
    }

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

    public int getTotal(){
        return items.stream()
                .map(item -> item.getImporte()) //Cambiamos el flujo para usar el  importe
                .reduce(0, (sum, importe) -> sum + importe); //Luego con la operacion reduce vamos sumando cada importe
    }
}
