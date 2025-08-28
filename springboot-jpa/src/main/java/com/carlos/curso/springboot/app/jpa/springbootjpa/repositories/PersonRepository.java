package com.carlos.curso.springboot.app.jpa.springbootjpa.repositories;


import com.carlos.curso.springboot.app.jpa.springbootjpa.dto.PersonDto;
import com.carlos.curso.springboot.app.jpa.springbootjpa.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


//Agregamos extends CrudRepository<Person, Long> para asi tener los metodos crud
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.id in ?1")
    List<Person> getPersonByIds(List<Long> ids);

    @Query("select p.name, length(p.name) from Person p where length(p.name)=(select min(length(p.name)) from Person p)")
    public List<Object[]>  getShorterName();

    @Query("select p from Person p where p.id = (select max(p.id) from Person p)")
    public Optional<Person> getLastRegistration();

    @Query("select min(p.id), max(p.id), sum(p.id), avg(length(p.name)), count(p.id) from Person p")
    public Object getResumeAggregation();

    @Query("select max(length(p.name) ) from Person p")
    public Long getMaxLengthName();

    @Query("select min(length(p.name)) from Person p")
    public Long getMinLengthName();

    @Query("select p.name, length(p.name) from Person p")
    public List<Object[]> getPersonNameLength();

    @Query("select count(p) from Person p")
    Long totalPerson();

    @Query("select min(p.id) from Person p")
    Long minId();

    @Query("select max(p.id) from Person p")
    Long maxId();

    List<Person> findByIdBetweenOrderByIdAsc(Long id1, Long id2);

    List<Person> findByNameBetweenOrderByNameDescLastnameAsc(String name1, String name2);

    List<Person> findByIdBetween(Long id1, Long id2);

    List<Person> findByNameBetween(String name1, String name2);

    @Query("select p from Person p where p.name between ?1 and ?2 order by p.name desc")
    List<Person> findAllBetweenName(String c1, String c2);

    @Query("select p from Person p where p.id between ?1 and ?2 order by p.name desc, p.lastname asc")
    List<Person> findAllBetweenId(Long id1, Long id2);

    @Query("SELECT p.id, upper(p.name), lower(p.lastname), upper(p.programmingLanguage) from Person p")
    List<Object[]> findAllPersonDataListCase();

    @Query("SELECT p.name || ' ' || p.lastname as fullname from Person p")
    List<String> findAllFullNameConcat();
    //@Query("SELECT CONCAT(p.name, ' ', p.lastname) as fullname from Person p")

    @Query("SELECT upper(p.name || ' ' || p.lastname) as fullname from Person p")
    List<String> findAllFullNameConcatUpper();

    @Query("SELECT lower(p.name || ' ' || p.lastname) as fullname from Person p")
    List<String> findAllFullNameConcatLower();

    @Query("select p.name from Person p")
    List<String> findAllNames();


    @Query("select distinct(p.name) from Person p")
    List<String> findAllNamesDistinct();

    @Query("select distinct(p.programmingLanguage) from Person p")
    List<String> findAllProgrammingLanguageDistinct();

    @Query("select count(distinct(p.programmingLanguage)) from Person p")
    Long findAllProgrammingLanguageDistinctCount();

    @Query("select new com.carlos.curso.springboot.app.jpa.springbootjpa.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> finAllPersonDto();

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
