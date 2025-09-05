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

import java.util.Optional;

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
        oneToMany();
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