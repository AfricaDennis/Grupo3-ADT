package com.reto2.grupo3.repository;

import com.reto2.grupo3.model.Student.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
