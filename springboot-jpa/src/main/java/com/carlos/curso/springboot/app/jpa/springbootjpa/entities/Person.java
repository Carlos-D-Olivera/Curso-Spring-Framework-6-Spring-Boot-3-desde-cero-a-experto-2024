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

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="created_at")
    private LocalDateTime createdAt;

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


    //@PrePersist: Este metodo se ejecuta antes de que la identidad sea guardada en la base de datos
    /*
    * Útil para:
        Actualizar campos como lastModifiedAt o updatedAt.

        Aplicar validaciones o transformaciones antes de un UPDATE.
    * */
    @PrePersist
    public void prePersist(){
        System.out.println("Evento del ciclo de vida del entity pre-persist");
        this.createdAt = LocalDateTime.now();
    }


    //@PreUpdate: Este metodo se ejecuta despues de actualizar la entidad en la base de datos
    /*  Útil para:
        Inicializar valores por defecto.

        Asignar fechas de creación (createdAt).

        Generar UUIDs, tokens, etc.     */
    @PreUpdate
    public void preUpdate(){
        System.out.println("Evento del ciclo de vida del entity pre-update");
        this.updatedAt = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastname + '\'' +
                ", programmingLanguage='" + programmingLanguage + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
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
}
