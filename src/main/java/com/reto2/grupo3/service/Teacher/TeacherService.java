package com.reto2.grupo3.service.Teacher;

import com.reto2.grupo3.model.Teacher.TeacherPostRequest;
import com.reto2.grupo3.model.Teacher.TeacherServiceModel;

import java.util.List;

public interface TeacherService {
    List<TeacherServiceModel> getAll();
    TeacherServiceModel getTeacher(Integer id);
    TeacherServiceModel createTeacher(TeacherPostRequest teacherPostRequest);
    TeacherServiceModel updateTeacher(Integer id, TeacherPostRequest teacherPostRequest);
    void deleteTeacherById(Integer id);
}
