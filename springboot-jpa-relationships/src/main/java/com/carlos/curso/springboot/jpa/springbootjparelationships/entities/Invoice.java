package com.carlos.curso.springboot.jpa.springbootjparelationships.entities;

import jakarta.persistence.*;

@Entity
@Table(name="invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Long total;

    @ManyToOne //Muchas facturas le pertenecen a un cliente
    @JoinColumn(name="client_id") //si queremos cambiar el nombre de la columna por default, si no se coloca client_id
    private Client client;

    @Embedded
    private Audit audit = new Audit();

    public Invoice() {
    }

    public Invoice(String description, Long total) {
        this.total = total;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", total=" + total +
                ", client=" + client.getId() +
                //", createdAt=" + audit.getCreatedAt() +
                //", updatedAt=" + audit.getUpdatedAt() +
                '}';
    }
}
