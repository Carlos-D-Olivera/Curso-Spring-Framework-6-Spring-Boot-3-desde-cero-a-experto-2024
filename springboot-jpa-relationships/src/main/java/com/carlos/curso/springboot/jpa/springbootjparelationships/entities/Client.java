package com.carlos.curso.springboot.jpa.springbootjparelationships.entities;

import jakarta.persistence.*;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;

    @Embedded
    private Audit audit = new Audit();

    public Client() {
    }

    public Client(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
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

    @Override
    public String toString() {
        return "{id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                //", createdAt='" + audit.getCreatedAt() + '\'' +
                //", updatedAt='" + audit.getUpdatedAt() + '\'' +

                '}';
    }

}
