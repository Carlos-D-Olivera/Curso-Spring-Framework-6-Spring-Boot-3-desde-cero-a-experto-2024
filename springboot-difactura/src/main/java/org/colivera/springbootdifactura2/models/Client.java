package org.colivera.springbootdifactura2.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //significa que sera gestionado por el contenedor de spring y podra ser inyectado
public class Client {

    @Value("${client.name}")
    private String name;
    @Value("${client.lastname}")
    private String lastName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
