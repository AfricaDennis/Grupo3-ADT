package com.reto2.grupo3.service.Teacher;


import com.reto2.grupo3.model.Teacher.Teacher;
import com.reto2.grupo3.model.Teacher.TeacherPostRequest;
import com.reto2.grupo3.model.Teacher.TeacherServiceModel;
import com.reto2.grupo3.repository.TeacherRepository;
import com.reto2.grupo3.service.Favorite.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<TeacherServiceModel> getAll() {
        Iterable<Teacher> teachers = teacherRepository.findAll();
        List<TeacherServiceModel> response = new ArrayList<>();

        for (Teacher teacher : teachers) {
            response.add(
                    new TeacherServiceModel(
                            teacher.getId(),
                            teacher.getName(),
                            teacher.getSurname(),
                            teacher.getPassword(),
                            teacher.getEmail(),
                            teacher.getPhone(),
                            teacher.getLocation(),
                            teacher.getShift(),
                            teacher.getPhoto(),
                            teacher.getFavorites(),
                            teacher.getOpinions(),
                            teacher.getDescription()
                    )
            );
        }
        return response;
    }

    @Override
    public TeacherServiceModel getTeacher(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe profesor"));

        TeacherServiceModel response = new TeacherServiceModel(
                teacher.getId(),
                teacher.getName(),
                teacher.getSurname(),
                teacher.getPassword(),
                teacher.getEmail(),
                teacher.getPhone(),
                teacher.getLocation(),
                teacher.getShift(),
                teacher.getPhoto(),
                teacher.getFavorites(),
                teacher.getOpinions(),
                teacher.getDescription()
        );
        return response;
    }

    @Override
    public TeacherServiceModel createTeacher(TeacherPostRequest teacherPostRequest) {

        Teacher teacher = new Teacher(
                teacherPostRequest.getId(),
                teacherPostRequest.getName(),
                teacherPostRequest.getSurname(),
                teacherPostRequest.getPassword(),
                teacherPostRequest.getEmail(),
                teacherPostRequest.getPhone(),
                teacherPostRequest.getLocation(),
                teacherPostRequest.getShift(),
                teacherPostRequest.getPhoto(),
                teacherPostRequest.getDescription(),
                teacherPostRequest.getFavorites(),
                teacherPostRequest.getOpinions()
        );


        Teacher queryTeacher = teacherRepository.save(teacher);
        TeacherServiceModel response = new TeacherServiceModel(
                queryTeacher.getId(),
                queryTeacher.getName(),
                queryTeacher.getSurname(),
                queryTeacher.getPassword(),
                queryTeacher.getEmail(),
                queryTeacher.getPhone(),
                queryTeacher.getLocation(),
                queryTeacher.getShift(),
                queryTeacher.getPhoto(),
                queryTeacher.getFavorites(),
                queryTeacher.getOpinions(),
                queryTeacher.getDescription()
        );

        return response;
    }

    @Override
    public TeacherServiceModel updateTeacher(Integer id, TeacherPostRequest teacherPostRequest) {

        Teacher teacher = teacherRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el profesor")
        );

        if (teacherPostRequest.getDescription() != null) {
            teacher.setDescription(teacherPostRequest.getDescription());
        }
        if(teacherPostRequest.getLocation() != null){
            teacher.setLocation(teacherPostRequest.getLocation());
        }
        if(teacherPostRequest.getPhoto() != null){
            teacher.setPhoto(teacherPostRequest.getPhoto());
        }
        if(teacherPostRequest.getShift() != null){
            teacher.setShift(teacherPostRequest.getShift());
        }


        Teacher queryTeacher = teacherRepository.save(teacher);
        TeacherServiceModel response = new TeacherServiceModel(
                queryTeacher.getId(),
                queryTeacher.getName(),
                queryTeacher.getSurname(),
                queryTeacher.getPassword(),
                queryTeacher.getEmail(),
                queryTeacher.getPhone(),
                queryTeacher.getLocation(),
                queryTeacher.getShift(),
                queryTeacher.getPhoto(),
                queryTeacher.getFavorites(),
                queryTeacher.getOpinions(),
                queryTeacher.getDescription()
        );

        return response;
    }

    @Override
    public void deleteTeacherById(Integer id) {
        teacherRepository.deleteById(id);
    }
}
