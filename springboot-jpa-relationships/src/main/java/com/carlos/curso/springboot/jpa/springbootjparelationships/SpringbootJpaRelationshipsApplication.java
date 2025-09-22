package com.carlos.curso.springboot.jpa.springbootjparelationships;

import com.carlos.curso.springboot.jpa.springbootjparelationships.entities.*;
import com.carlos.curso.springboot.jpa.springbootjparelationships.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class SpringbootJpaRelationshipsApplication implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientDetailsRepository clientDetailsRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipsApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        ManyToManyBidireccionalFindRemove();
    }

    @Transactional
    public void ManyToManyBidireccionalFindRemove(){
        Optional<Student> optionalStudent1 = studentRepository.findOneWithCourses(1L);
        Optional<Student> optionalStudent2 = studentRepository.findOneWithCourses(2L);

        Student student1 = optionalStudent1.get();
        Student student2 = optionalStudent2.get();

        Course course1 = courseRepository.findOne(1L).get();
        Course course2 = courseRepository.findOne(2L).get();


        student1.addCourse(course1);
        student1.addCourse(course2);
        student2.addCourse(course2);


        studentRepository.saveAll(List.of(student1, student2));

        System.out.println(student1);
        System.out.println(student2);

        Optional<Student> studentOptionalDB = studentRepository.findOneWithCourses(1L);
        if(studentOptionalDB.isPresent()){
            Student studentDb = studentOptionalDB.get();
            Optional<Course> courseOptionalDb = courseRepository.findOne(1L);

            if(courseOptionalDb.isPresent()){
                Course courseDb = courseOptionalDb.get();
                studentDb.removeCourse(courseDb);

                studentRepository.save(studentDb);

                System.out.println(studentDb);
            }
        }

    }

    @Transactional
    public void ManyToManyBidireccionalFind(){
        Optional<Student> optionalStudent1 = studentRepository.findById(1L);
        Optional<Student> optionalStudent2 = studentRepository.findById(2L);

        Student student1 = optionalStudent1.get();
        Student student2 = optionalStudent2.get();

        Course course1 = courseRepository.findById(1L).get();
        Course course2 = courseRepository.findById(2L).get();


        student1.addCourse(course1);
        student1.addCourse(course2);
        student2.addCourse(course2);


        studentRepository.saveAll(List.of(student1, student2));

        System.out.println(student1);
        System.out.println(student2);

    }


    @Transactional
    public void ManyToManyBidireccionalRemove(){
        Student student1 = new Student("Jano", "Pura");
        Student student2 = new Student("Erba", "Doe");

        Course course1 = new Course("Curso de Java Master", "Andres");
        Course course2 = new Course("Curso de Spring boot", "Andres");

        student1.addCourse(course1);
        student1.addCourse(course2);

        student2.addCourse(course2);


        studentRepository.saveAll(List.of(student1, student2));

        System.out.println(student1);
        System.out.println(student2);

        Optional<Student> studentOptionalDB = studentRepository.findOneWithCourses(3L);
        if(studentOptionalDB.isPresent()){
            Student studentDb = studentOptionalDB.get();
            Optional<Course> courseOptionalDb = courseRepository.findOne(3L);

            if(courseOptionalDb.isPresent()){
                Course courseDb = courseOptionalDb.get();
                studentDb.removeCourse(courseDb);

                studentRepository.save(studentDb);

                System.out.println(studentDb);
            }
        }

    }

    @Transactional
    public void ManyToManyBidireccional(){
        Student student1 = new Student("Jano", "Pura");
        Student student2 = new Student("Erba", "Doe");

        Course course1 = new Course("Curso de Java Master", "Andres");
        Course course2 = new Course("Curso de Spring boot", "Andres");

//        student1.setCourses(Set.of(course1, course2));
//        student2.setCourses(Set.of(course2));
        student1.addCourse(course1);
        student1.addCourse(course2);

        student2.addCourse(course2);


        studentRepository.saveAll(List.of(student1, student2));

        System.out.println(student1);
        System.out.println(student2);

    }

    @Transactional
    public void ManyToManyRemove(){
        Student student1 = new Student("Jano", "Pura");
        Student student2 = new Student("Erba", "Doe");

        Course course1 = new Course("Curso de Java Master", "Andres");
        Course course2 = new Course("Curso de Spring boot", "Andres");

        student1.setCourses(Set.of(course1, course2));
        student2.setCourses(Set.of(course2));

        studentRepository.saveAll(List.of(student1, student2));

        System.out.println(student1);
        System.out.println(student2);

        Optional<Student> studentOptionalDB = studentRepository.findOneWithCourses(3L);
        if(studentOptionalDB.isPresent()){
            Student studentDb = studentOptionalDB.get();
            Optional<Course> courseOptionalDb = courseRepository.findById(3L);

            if(courseOptionalDb.isPresent()){
                Course courseDb = courseOptionalDb.get();
                studentDb.getCourses().remove(courseDb);

                studentRepository.save(studentDb);

                System.out.println(studentDb);
            }
        }

    }
    @Transactional
    public void ManyToManyRemoveFind(){
        Optional<Student> optionalStudent1 = studentRepository.findById(1L);
        Optional<Student> optionalStudent2 = studentRepository.findById(2L);

        Student student1 = optionalStudent1.get();
        Student student2 = optionalStudent2.get();

        Course course1 = courseRepository.findById(1L).get();
        Course course2 = courseRepository.findById(2L).get();

        student1.setCourses(Set.of(course1, course2));
        student2.setCourses(Set.of(course2));


        studentRepository.saveAll(List.of(student1, student2));

        System.out.println(student1);
        System.out.println(student2);

        Optional<Student> studentOptionalDB = studentRepository.findOneWithCourses(1L);
        if(studentOptionalDB.isPresent()){
            Student studentDb = studentOptionalDB.get();
            Optional<Course> courseOptionalDb = courseRepository.findById(2L);

            if(courseOptionalDb.isPresent()){
                Course courseDb = courseOptionalDb.get();
                studentDb.getCourses().remove(courseDb);

                studentRepository.save(studentDb);

                System.out.println(studentDb);
            }
        }
    }

    @Transactional
    public void ManyToManyFind(){
        Optional<Student> optionalStudent1 = studentRepository.findById(1L);
        Optional<Student> optionalStudent2 = studentRepository.findById(2L);

        Student student1 = optionalStudent1.get();
        Student student2 = optionalStudent2.get();

        Course course1 = courseRepository.findById(1L).get();
        Course course2 = courseRepository.findById(2L).get();

        student1.setCourses(Set.of(course1, course2));
        student2.setCourses(Set.of(course2));


        studentRepository.saveAll(List.of(student1, student2));

        System.out.println(student1);
        System.out.println(student2);
    }

    @Transactional
    public void ManyToMany(){
        Student student1 = new Student("Jano", "Pura");
        Student student2 = new Student("Erba", "Doe");

        Course course1 = new Course("Curso de Java Master", "Andres");
        Course course2 = new Course("Curso de Spring boot", "Andres");

        student1.setCourses(Set.of(course1, course2));
        student2.setCourses(Set.of(course2));

//        En vez de guardar uno por uno usamos SaveAll
//        studentRepository.save(student1);
//        studentRepository.save(student2);

        studentRepository.saveAll(List.of(student1, student2));

        System.out.println(student1);
        System.out.println(student2);

    }

    @Transactional
    public void OneToOneBidireccionalFindById(){

        Optional<Client> clientOptional = clientRepository.findOne(1L);
        clientOptional.ifPresent(client->{
            ClientDetails clientDetails = new ClientDetails(true, 5000);

            client.setClientDetails(clientDetails);

            clientRepository.save(client);

            System.out.println(client);
        });

    }

    @Transactional
    public void OneToOneBidireccional(){

        Client client = new Client("Erba", "Pura");

        ClientDetails clientDetails = new ClientDetails(true, 5000);

        client.setClientDetails(clientDetails);

        clientRepository.save(client);

        System.out.println(client);
    }

    @Transactional
    public void OneToOneFindById(){

        ClientDetails clientDetails = new ClientDetails(true, 5000);
        clientDetailsRepository.save(clientDetails);

        Optional<Client> clientOptional = clientRepository.findOne(2L);
        clientOptional.ifPresent(client -> {
            client.setClientDetails(clientDetails);
            clientRepository.save(client);

            System.out.println(client);
        });
    }

    @Transactional
    public void OneToOne(){

        ClientDetails clientDetails = new ClientDetails(true, 5000);
        clientDetailsRepository.save(clientDetails);

        Client client = new Client("Erba", "Pura");
        client.setClientDetails(clientDetails);
        clientRepository.save(client);

        System.out.println(client);
    }

    @Transactional
    public void removeInvoiceBidireccional() {

        //Optional<Client> optionalClient = Optional.of(new Client("Fran", "Moras"));
        Client client = new Client("Fran", "Moras");

        Invoice invoice1 = new Invoice("Compras de oficina", 40000L);
        Invoice invoice2 = new Invoice("Compras de la casa", 5000L);
        Invoice invoice3 = new Invoice("Compras del supermercado", 8000L);

        client.addInvoice(invoice1).addInvoice(invoice2).addInvoice(invoice3);

        clientRepository.save(client);

        System.out.println(invoice3);
        System.out.println(client);


        Optional<Client> optionalClientBd = clientRepository.findOne(3L);

        optionalClientBd.ifPresent(clientBd->{
            Optional<Invoice> invoiceOptional = invoiceRepository.findById(2L);
            invoiceOptional.ifPresent(invoice->{
                clientBd.removeInvoice(invoice);
                invoice.setClient(null);

                clientRepository.save(clientBd);
                System.out.println(clientBd);
            });
        });

    }

    @Transactional
    public void RemoveOneToManyInvoiceBidireccionalFindById() {

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

        Optional<Client> optionalClientBd = clientRepository.findOne(1L);

        optionalClientBd.ifPresent(client->{
            Optional<Invoice> invoiceOptional = invoiceRepository.findById(2L);
            invoiceOptional.ifPresent(invoice->{
                client.removeInvoice(invoice);
                invoice.setClient(null);

                clientRepository.save(client);
                System.out.println(client);
            });
        });

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