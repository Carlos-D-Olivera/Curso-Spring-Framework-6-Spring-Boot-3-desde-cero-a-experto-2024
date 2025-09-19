package com.carlos.curso.springboot.jpa.springbootjparelationships.entities;

import jakarta.persistence.*;

import java.util.*;

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
    private Set<Address> addresses;

    @Embedded
    private Audit audit = new Audit();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "client")
    private Set<Invoice> invoices;
    //private List<Invoice> invoices;

    public Client() {
        addresses = new HashSet<>();
        //addresses = new ArrayList<>();
        invoices = new HashSet<>();
        //invoices = new ArrayList<>();
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Client addInvoice(Invoice invoice){
        invoice.setClient(this);
        this.invoices.add(invoice);
        return this;
    }

    public void removeInvoice(Invoice invoice) {
        this.invoices.remove(invoice);
        invoice.setClient(null);
    }

    @Override
    public String toString() {
        return "Client {id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", invoices='" + invoices + '\'' +
                //", createdAt='" + audit.getCreatedAt() + '\'' +
                //", updatedAt='" + audit.getUpdatedAt() + '\'' +
                ", addresses='" + addresses + '\'' +

                '}';
    }
}
