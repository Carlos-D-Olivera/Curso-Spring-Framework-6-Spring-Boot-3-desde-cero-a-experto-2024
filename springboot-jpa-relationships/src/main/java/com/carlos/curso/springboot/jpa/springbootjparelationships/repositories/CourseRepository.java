package com.carlos.curso.springboot.jpa.springbootjparelationships.repositories;

import com.carlos.curso.springboot.jpa.springbootjparelationships.entities.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query("select c from Course c left join fetch students where c.id = ?1")
    Optional<Course> findOne(Long id);
}
