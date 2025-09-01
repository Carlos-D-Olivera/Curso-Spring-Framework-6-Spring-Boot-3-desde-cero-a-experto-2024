package com.carlos.curso.springboot.app.jpa.springbootjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

/*
*
* @Embeddable:  Se coloca en una clase no entidad que representa un objeto reutilizable de valores.
                Define un conjunto de campos que podrán ser incrustados en otras entidades.
                No tiene su propia tabla.
                Sus atributos se mapean en la tabla de la entidad que lo contiene.
*
* */

@Embeddable
public class Audit {

    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    //@PrePersist: Este metodo se ejecuta antes de que la identidad sea guardada en la base de datos
    /*
        Útil para:
        Actualizar campos como lastModifiedAt o updatedAt.
        Aplicar validaciones o transformaciones antes de un UPDATE.
    */
    @PrePersist
    public void prePersist(){
        System.out.println("Evento del ciclo de vida del entity pre-persist");
        this.createdAt = LocalDateTime.now();
    }


    //@PreUpdate: Este metodo se ejecuta despues de actualizar la entidad en la base de datos
    /*
    Útil para:
    Inicializar valores por defecto.
    Asignar fechas de creación (createdAt).
    Generar UUIDs, tokens, etc.
    */
    @PreUpdate
    public void preUpdate(){
        System.out.println("Evento del ciclo de vida del entity pre-update");
        this.updatedAt = LocalDateTime.now();
    }


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
