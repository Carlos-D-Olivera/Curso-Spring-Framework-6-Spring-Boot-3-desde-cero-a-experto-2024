package com.carlos.curso.springboot.app.jpa.springbootjpa;

import com.carlos.curso.springboot.app.jpa.springbootjpa.entities.Person;
import com.carlos.curso.springboot.app.jpa.springbootjpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Como no vamos a trabajar con web debemos implementar CommandLineRunner implements CommandLineRunner
@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        findOne2();
    }


    public void create(){
        Person person = new Person(null, "Lalo", )
    }


    public void findOne(){
        Person person = null;
        //Optional<Person> optionalPerson = repository.findById(1L);
        Optional<Person> optionalPerson = repository.findOne(1L);
        //Person person = repository.findById(1L).orElseThrow();
        if(optionalPerson.isPresent()){
            person = optionalPerson.get();
        }
        System.out.println(person);
    }

    public void findOne2(){
        //repository.findById(1L).ifPresent(person -> System.out.println(person));
        //repository.findById(1L).ifPresent(System.out::println);
        repository.findOne(1L).ifPresent(System.out::println);
        repository.findOneLikeName("ri").ifPresent(System.out::println);
    }


    public void list(){
        String lenguaje = "Java";
        String palabra1 = "a";
        String palabra2 = "e";

        //Downcasting: de un tipo mas general a uno mas especifico
        List<Person> persons = (List<Person>) repository.findByProgrammingLanguage(lenguaje);
        List<Person> persons2 = (List<Person>) repository.findPersonByNameContains(palabra1);
        List<Person> persons3 = (List<Person>) repository.findPersonByNameContains(palabra2);
        List<Person> persons4 = (List<Person>) repository.buscarByProgrammingLanguageYNombre("Java", "Carlos");

        System.out.println("\nLISTA DE PERSONAS DEL LENGUAJE "+lenguaje);
        persons.stream().forEach(person -> {
            System.out.println(person);
        });

        System.out.println("\nLISTA DE PERSONAS QUE SU NOMBRE CONTIENE "+palabra1);
        persons2.stream().forEach(person -> {
            System.out.println(person);
        });

        System.out.println("\nLISTA DE PERSONAS QUE SU NOMBRE CONTIENE "+palabra2);
        persons3.stream().forEach(person -> {
            System.out.println(person);
        });

        System.out.println("\nLISTA DE PERSONAS QUE SU NOMBRE ES CARLOS Y SU LENGUAJE ES JAVA ");
        persons4.stream().forEach(person -> {
            System.out.println(person);
        });



        List<Object[]> personsValues = repository.obtenerPersonData();
        personsValues.stream().forEach(person ->{
            System.out.println(person[0] + " es experto en "+ person[1]);
            System.out.println(Arrays.toString(person));
        });
    }

}
