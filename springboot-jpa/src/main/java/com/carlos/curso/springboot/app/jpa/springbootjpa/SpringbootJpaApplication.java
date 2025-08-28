package com.carlos.curso.springboot.app.jpa.springbootjpa;

import com.carlos.curso.springboot.app.jpa.springbootjpa.dto.PersonDto;
import com.carlos.curso.springboot.app.jpa.springbootjpa.entities.Person;
import com.carlos.curso.springboot.app.jpa.springbootjpa.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
        queriesFunctionAggregation();
    }

    @Transactional(readOnly = true)
    public void subQueries(){

    }

    @Transactional(readOnly = true)
    public void  queriesFunctionAggregation(){
        System.out.println("============== consulta con el total de registros de la tabla persona ==============");
        Long count = repository.totalPerson();
        System.out.println("Cantidad de total de personas : "+count);
        Long min = repository.minId();
        System.out.println("Id minimo : "+min);
        Long max = repository.maxId();
        System.out.println("Id maximo : "+max);


        System.out.println("consulta con el nombre y su largo");
        List<Object[]> regs = repository.getPersonNameLength();
        regs.forEach( reg -> {
            String name = (String) reg[0];
            Integer length = (Integer) reg[1];
            System.out.println("name= "+name+", length=" + length);
        });

    }

    @Transactional(readOnly = true)
    public void personalizedQueriesBetween(){
        System.out.println("==============consultas por rangos ==============");
        List<Person> persons = this.repository.findByIdBetweenOrderByIdAsc(2L, 5L);
        persons.forEach(System.out::println);

        System.out.println("==============consultas por rangos nombre ==============");
        persons = this.repository.findByNameBetweenOrderByNameDescLastnameAsc("J", "P");
        persons.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void personalizedQueriesConcatUpperAndLowerCase(){
        System.out.println("==============consultas nombres y apellidos de personas==============");
        List<String> fullNames = repository.findAllFullNameConcat();

        fullNames.forEach(System.out::println);

        System.out.println("==============consultas nombres y apellidos mayuscula==============");
        fullNames = repository.findAllFullNameConcatUpper();

        fullNames.forEach(System.out::println);


        System.out.println("==============consultas nombres y apellidos minuscula==============");
        fullNames = repository.findAllFullNameConcatLower();

        System.out.println("==============consultas personalizada upper and lower case==============");
        List<Object[]> personReg = repository.findAllPersonDataListCase();
        personReg.forEach(reg -> System.out.println("id = "+reg[0]+", nombre = "+reg[1]+", apellido = "+reg[2]+", lenguaje de programacion = "+reg[3]));
    }

    @Transactional(readOnly = true)
    public void personalizedQueriesDistinct(){
        System.out.println("==============consultas con nombres de personas==============");
        List<String> names = repository.findAllNames();
        names.forEach(System.out::println);


        System.out.println("==============consultas con nombres Unicos de personas==============");
        names = repository.findAllNamesDistinct();
        names.forEach(System.out::println);

        System.out.println("==============consultas con lenguajes de programacion Unicos de personas==============");
        names = repository.findAllProgrammingLanguageDistinct();
        names.forEach(System.out::println);

        System.out.println("==============consultas con total lenguajes de programacion Unicos de personas==============");
        Long totalLanguages = repository.findAllProgrammingLanguageDistinctCount();
        System.out.println("Total de lenguajes de programacion: "+totalLanguages);
    }

    @Transactional(readOnly = true)
    public void personalizedQueries2(){

        System.out.println("==============Consulta por objeto persona y lenguaje de programacion ================");
        List<Object[]> personRegs = repository.findAllMixPerson();

        personRegs.forEach(reg->{
            System.out.println("programmingLanguage=" + reg[1] + ", person "+reg[0]);
        });

        System.out.println("==============Consulta que puebla y devuelve objeto entity de una instancia personalizada ================");
        List<Person> persons = repository.finAllObjectPersonalized();
        persons.forEach(System.out::println);

        System.out.println("==============Consulta que puebla y devuelve objeto DTO de una instancia personalizada ================");
        List<PersonDto> personsDto = repository.finAllPersonDto();
        personsDto.forEach(System.out::println);

    }

    @Transactional(readOnly = true)
    public void personalizedQueries(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("==============Consulta solo el nombre por el id================");

        System.out.print("Digite el id para obtener el nombre: ");
        Long id = scanner.nextLong();

        String name = repository.getNameById(id);
        System.out.println(name);

        String fullName = repository.getFullNameById(id);
        System.out.println(fullName);

        String programmingLanguage = repository.getProgrammingLanguageById(id);
        System.out.println(programmingLanguage);

        System.out.println("==============Consulta por campos personalizados================");
        Object[] personReg = (Object[]) repository.obtenerPersonDataById(id);
        System.out.println("id = "+personReg[0]+", nombre = "+personReg[1]+", apellido = "+personReg[2]+", lenguaje de programacion = "+personReg[3]);


        System.out.println("==============Consulta por campos personalizados lista ================");
        List<Object[]> regs = repository.obtenerPersonDataList();
        regs.forEach(reg -> System.out.println("id = "+reg[0]+", nombre = "+reg[1]+", apellido = "+reg[2]+", lenguaje de programacion = "+reg[3]));
    }


    @Transactional
    public void delete(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id de la persona a editar: ");
        Long id = scanner.nextLong();

        Optional<Person> optionalPerson = repository.findById(id);

        optionalPerson.ifPresentOrElse( repository::delete,
            ()->System.out.println("No existe la persona con ese id")
        );

        repository.findAll().forEach(System.out::println);
    }

    @Transactional
    public void update(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el id de la persona a editar: ");
        Long id = scanner.nextLong();

        //Obtenemos una persona para actualizarla
        Optional<Person> personOptional = repository.findById(id);

        /*personOptional.ifPresent(
                person -> {

                    System.out.println(person);

                    System.out.print("Ingrese el lenguaje de programacion:");
                    String programmingLanguage = scanner.next();

                    person.setProgrammingLanguage(programmingLanguage);

                    Person personUpdate = repository.save(person);

                    System.out.println(personUpdate);
                }
        );*/

        if(personOptional.isPresent()){

            Person personUpdate = personOptional.orElseThrow();
            System.out.println(personUpdate);

            System.out.print("Ingrese el lenguaje de programacion:");
            String programmingLanguage = scanner.next();

            personUpdate.setProgrammingLanguage(programmingLanguage);

            repository.save(personUpdate);

        }else {
            System.out.println("No se encontro la persona a editar");
        }

        scanner.close();
    }


    @Transactional
    public void create(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite el nombre: ");
        String name = scanner.nextLine().trim();

        System.out.print("Digite el apellido: ");
        String lastname = scanner.nextLine().trim();

        System.out.print("Digite el lenguaje de progracion: ");
        String programmingLanguage = scanner.nextLine().trim();

        scanner.close();

        //Person person = new Person(null, "Lalo", "Thor", "Python");
        Person person = new Person(null, name, lastname, programmingLanguage);

        Person personNew = repository.save(person); //Si el id  es null lo inserta si no hace un update

        System.out.println(personNew);

        repository.findById(personNew.getId()).ifPresent(System.out::println);
    }


    @Transactional(readOnly = true) //Se crea un transaccion de solo lectura, si todo sale bien se hace el commit
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

    @Transactional(readOnly = true) //Se crea un transaccion de solo lectura, si todo sale bien se hace el commit
    public void findOne2(){
        //repository.findById(1L).ifPresent(person -> System.out.println(person));
        //repository.findById(1L).ifPresent(System.out::println);
        repository.findOne(1L).ifPresent(System.out::println);
        repository.findOneLikeName("ri").ifPresent(System.out::println);
    }


    @Transactional(readOnly = true) //Se crea un transaccion de solo lectura, si todo sale bien se hace el commit
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
