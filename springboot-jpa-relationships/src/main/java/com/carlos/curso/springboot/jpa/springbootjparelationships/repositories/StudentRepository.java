package com.carlos.curso.springboot.jpa.springbootjparelationships.repositories;

import com.carlos.curso.springboot.jpa.springbootjparelationships.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("select s from Student s left join fetch s.courses where s.id = ?1")
    Optional<Student> findOneWithCourses(Long id);
}
