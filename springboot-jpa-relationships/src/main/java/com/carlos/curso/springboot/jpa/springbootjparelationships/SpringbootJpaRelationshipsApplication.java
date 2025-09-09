package com.carlos.curso.springboot.jpa.springbootjparelationships;

import com.carlos.curso.springboot.jpa.springbootjparelationships.entities.Address;
import com.carlos.curso.springboot.jpa.springbootjparelationships.entities.Client;
import com.carlos.curso.springboot.jpa.springbootjparelationships.entities.Invoice;
import com.carlos.curso.springboot.jpa.springbootjparelationships.repositories.ClientRepository;
import com.carlos.curso.springboot.jpa.springbootjparelationships.repositories.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class SpringbootJpaRelationshipsApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipsApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        oneToManyInvoiceBidireccionalFindById();
    }

    @Transactional
    public void oneToManyInvoiceBidireccionalFindById() {

        Optional<Client> optionalClient = clientRepository.findOne(1L);

        optionalClient.ifPresent(client -> {

            Invoice invoice1 = new Invoice("Compras de oficina", 40000L);
            Invoice invoice2 = new Invoice("Compras de la casa", 5000L);
            Invoice invoice3 = new Invoice("Compras del supermercado", 8000L);

            client.addInvoice(invoice1).addInvoice(invoice2).addInvoice(invoice3);

            clientRepository.save(client);

            System.out.println(invoice3);
            System.out.println(client);

        });

    }


    @Transactional
    public void oneToManyInvoiceBidireccional() {
        Client client = new Client("Fran", "Moras");

        Invoice invoice1 = new Invoice("Compras de oficina", 40000L);
        Invoice invoice2 = new Invoice("Compras de la casa", 5000L);
        Invoice invoice3 = new Invoice("Compras del supermercado", 8000L);

        client.addInvoice(invoice1).addInvoice(invoice2).addInvoice(invoice3);

        clientRepository.save(client);

        System.out.println(invoice3);
        System.out.println(client);
    }

    @Transactional
    public void removeAddressFindByIdClient(){

        Optional<Client> optionalClient = clientRepository.findById(2L);

        optionalClient.ifPresent(client -> {
            Address address1 = new Address("El verjel", 1234);
            Address address2 = new Address("Vasco de Gama", 9875);

            Set<Address> addresses = new HashSet<>();
            addresses.add(address1);
            addresses.add(address2);
            client.setAddresses(addresses);

            System.out.println("\n--------------------------------------------------------------------------------");

            Client clientSaved = clientRepository.save(client);
            Address address2saved = clientSaved.getAddresses().stream()
                    .filter(a -> a.getNumber().equals(address2.getNumber()))
                    .findFirst().orElseThrow();

            System.out.println("--------------------------------------------------------------------------------\n");

            System.out.println(client);
            System.out.println(address2);

            Optional<Client> optionalClient2 = clientRepository.findById(2L);
            optionalClient2.ifPresent(c->{
                c.getAddresses().remove(address2saved);
                clientRepository.save(c);
                System.out.println(c);
            });

        });
    }


    @Transactional
    public void removeAddress(){
        Client client = new Client("Fran", "Moras");

        Address address1 = new Address("El verjel", 1234);
        Address address2 = new Address("Vasco de Gama", 9875);

        client.getAddresses().add(address1);
        client.getAddresses().add(address2);

        //Cuando guardamos el cliente se guardan automaticante las direcciones ya que la relacion esta en Cascade

        clientRepository.save(client);

        System.out.println(address1);

        System.out.println(client);

        Optional<Client> optionalClient = clientRepository.findById(3L);
        optionalClient.ifPresent(c -> {
            c.getAddresses().remove(address1); //La eliminamos de la lista de direcciones
            clientRepository.save(c); //Lo guardamos en la bd
            System.out.println(c);
        });
    }


    @Transactional
    public void oneToMany(){
        Client client = new Client("Fran", "Moras");

        Address address1 = new Address("El vejel", 1234);
        Address address2 = new Address("Vasco de Gama", 9875);

        client.getAddresses().add(address1);
        client.getAddresses().add(address2);

        //Cuando guardamos el cliente se guardan automaticante las direcciones ya que la relacion esta en Cascade

        clientRepository.save(client);
    }

    @Transactional
    public void manyToOne(){

        Client client = new Client("Jhon","Doe");
        System.out.println(clientRepository.save(client)); //Lo guardamos en la bd

        Invoice invoice = new Invoice("Compras de oficina", 20000L);
        invoice.setClient(client);

        //Invoice invoiceDb = invoiceRepository.save(invoice);
        //System.out.println(invoiceDb);

        System.out.println(invoiceRepository.save(invoice));
    }

    @Transactional
    public void manyToOneFindByIdClient(){

        Optional<Client> optionalClient = clientRepository.findById(1L);

        if(optionalClient.isPresent()){
            Client client = optionalClient.orElseThrow();

            Invoice invoice = new Invoice("Compras de oficina", 20000L);
            invoice.setClient(client);

            System.out.println(invoiceRepository.save(invoice));
        }
    }
}