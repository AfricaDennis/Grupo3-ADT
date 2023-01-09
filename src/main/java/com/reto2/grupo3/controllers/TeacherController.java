package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.Favorite.FavoritePostRequest;
import com.reto2.grupo3.model.Favorite.FavoriteServiceModel;
import com.reto2.grupo3.model.Teacher.TeacherPostRequest;
import com.reto2.grupo3.model.Teacher.TeacherServiceModel;
import com.reto2.grupo3.service.Teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherServiceModel>> getTeachers(){
        return new ResponseEntity<>(teacherService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/teachers/{id}")
    public ResponseEntity<TeacherServiceModel> getTeacherById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(teacherService.getTeacher(id), HttpStatus.OK);
    }

    @PostMapping(value ="/teachers", consumes = {"application/json"})
    public ResponseEntity<TeacherServiceModel> createTeacher(@RequestBody TeacherPostRequest teacherPostRequest) {
        return new ResponseEntity<>(teacherService.createTeacher(teacherPostRequest), HttpStatus.CREATED);
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<TeacherServiceModel> updateTeacherById(@PathVariable("id") Integer id, @RequestBody TeacherPostRequest teacherPostRequest) {
        return new ResponseEntity<>(teacherService.updateTeacher(id, teacherPostRequest), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<?> deleteTeacherById(@PathVariable("id") Integer id) {
        try {
            teacherService.deleteTeacherById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe el profesor");
        }
    }
}
