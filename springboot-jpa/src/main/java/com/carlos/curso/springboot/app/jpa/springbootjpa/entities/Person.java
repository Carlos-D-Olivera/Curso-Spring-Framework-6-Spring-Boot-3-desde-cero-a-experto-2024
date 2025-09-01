package com.carlos.curso.springboot.app.jpa.springbootjpa.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity //Se anota con @Entity para indicar que es una clase de persistencia
@Table(name = "persons") //Opcional: solo para indicar el nombre de la tabla en la BD si no se usa el mismo nomnbre de la clase
public class Person {

    @Id //Indicamos que es la llave primaria
    @GeneratedValue(strategy = IDENTITY) //Indicamos que la llave primaria es autoincremental en la BD
    private Long id;

    private String name;
    private String lastname;

    @Column(name = "programming_language")//Opcional: se usa cuando la columna tiene nombre diferente en la base de datos
    private String programmingLanguage;

    @Embedded //Se usa dentro de una entidad para indicar que un campo es un objeto embebido (@Embeddable).
    private Audit audit = new Audit();

    public Person() {
    }

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Person(Long id, String name, String lastName, String programmingLanguage) {
        this.id = id;
        this.name = name;
        this.lastname = lastName;
        this.programmingLanguage = programmingLanguage;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastname + '\'' +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                ", createdAt='" + audit.getCreatedAt() + '\'' +
                ", updatedAt='" + audit.getUpdatedAt() + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

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
