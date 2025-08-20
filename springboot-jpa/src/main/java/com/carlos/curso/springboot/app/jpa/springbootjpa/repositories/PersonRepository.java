package com.carlos.curso.springboot.app.jpa.springbootjpa.repositories;


import com.carlos.curso.springboot.app.jpa.springbootjpa.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


//Agregamos extends CrudRepository<Person, Long> para asi tener los metodos crud
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> finAllObjectPersonalized();

    @Query("select p.name from Person p where p.id =?1")
    String getNameById(Long id);

    @Query("select concat(p.name,' ',p.lastname) from Person p where p.id =?1")
    String getFullNameById(Long id);

    @Query("select p.programmingLanguage from Person p where p.id =?1")
    String getProgrammingLanguageById(Long id);

    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id =?1")
    Object obtenerPersonDataById(Long id);

    @Query("SELECT p FROM Person p where p.id=?1")
    Optional<Person> findOne(Long id);

    @Query("SELECT p FROM Person p where p.name=?1")
    Optional<Person> findOneName(String name);

    @Query("SELECT p FROM Person p where p.name LIKE %?1%")
    Optional<Person> findOneLikeName(String name);

    List<Person> findByProgrammingLanguage(String programingLanguage);

    //Con @Query podemos definir consultas personalizadas o especificas
    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarByProgrammingLanguageYNombre (String programingLanguage, String name);

    List<Person> findPersonByNameContains(String word); //Devuelve la lista de personas que contienen la palabra en el nombre

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();

    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMixPerson();

    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonDataList();
}
