package org.colivera.springbootdifactura2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
//import org.springframework.web.context.annotation.SessionScope;

@Component //significa que sera gestionado por el contenedor de spring y podra ser inyectado
//@SessionScope //El objeto cliente sera unico por cada sesion
@RequestScope //El cliente se creara en cada peticion
//@JsonIgnoreProperties({"targetSource", "advisors"})
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
