package com.carlos.curso.springboot.jpa.springbootjparelationships.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER) //Un cliente tiene muchas direcciones
    @JoinTable(name = "tbl_clientes_to_direcciones"
            ,joinColumns = @JoinColumn(name = "id_cliente")
            ,inverseJoinColumns = @JoinColumn(name = "id_direcciones")
            ,uniqueConstraints = @UniqueConstraint(columnNames = {"id_direcciones"})
    ) //Esta va a ser la tabla de relacion entre ambas tablas
    private List<Address> addresses;

    @Embedded
    private Audit audit = new Audit();

    public Client() {
        addresses = new ArrayList<>();
    }

    public Client(String lastName, String name) {
        this();
        this.lastName = lastName;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                //", createdAt='" + audit.getCreatedAt() + '\'' +
                //", updatedAt='" + audit.getUpdatedAt() + '\'' +
                ", addresses='" + addresses + '\'' +

                '}';
    }

}
