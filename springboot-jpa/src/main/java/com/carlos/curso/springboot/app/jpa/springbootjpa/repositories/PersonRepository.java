package com.carlos.curso.springboot.app.jpa.springbootjpa.repositories;


import com.carlos.curso.springboot.app.jpa.springbootjpa.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;


//Agregamos extends CrudRepository<Person, Long> para asi tener los metodos crud
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByProgrammingLanguage(String programingLanguage);

    //Con @Query podemos definir consultas personalizadas o especificas
    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarByProgrammingLanguageYNombre (String programingLanguage, String name);

    List<Person> findPersonByNameContains(String word); //Devuelve la lista de personas que contienen la palabra en el nombre

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();
}
