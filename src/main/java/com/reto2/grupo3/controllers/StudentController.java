package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.Student.StudentPostRequest;
import com.reto2.grupo3.model.Student.StudentServiceModel;
import com.reto2.grupo3.service.Student.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentServiceModel>> getStudents(){
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentServiceModel> getStudentById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @PostMapping(value = "/students", consumes = {"application/json"})
    public ResponseEntity<StudentServiceModel> createStudent(@RequestBody StudentPostRequest studentPostRequest){
        return new ResponseEntity<>(studentService.createStudent(studentPostRequest), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentServiceModel> updateStudentById(@PathVariable("id") Integer id, @RequestBody StudentPostRequest studentPostRequest){
        return new ResponseEntity<>(studentService.updateStudent(id, studentPostRequest), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") Integer id) {
        try {
            studentService.deleteStudentById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe el estudiante");
        }
    }

}
