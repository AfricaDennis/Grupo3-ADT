package com.reto2.grupo3.service.Student;

import com.reto2.grupo3.model.Student.StudentPostRequest;
import com.reto2.grupo3.model.Student.StudentServiceModel;

import java.util.List;

public interface StudentService {
    List<StudentServiceModel> getAll();
    StudentServiceModel getStudent(Integer id);
    StudentServiceModel createStudent(StudentPostRequest studentPostRequest);
    StudentServiceModel updateStudent(Integer id, StudentPostRequest studentPostRequest);
    void deleteStudentById(Integer id);
}
