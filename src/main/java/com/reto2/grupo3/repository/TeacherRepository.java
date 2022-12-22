package com.reto2.grupo3.repository;

import com.reto2.grupo3.model.Teacher.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
}
