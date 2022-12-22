package com.reto2.grupo3.model;


import com.reto2.grupo3.model.Student.StudentServiceModel;
import com.reto2.grupo3.model.Teacher.TeacherServiceModel;

public class FavoriteServiceModel {

    private Integer id;
    private TeacherServiceModel teacher;
    private Integer id_teacher;
    private StudentServiceModel student;
    private Integer id_student;

    public FavoriteServiceModel() {
    }

    public FavoriteServiceModel(Integer id, TeacherServiceModel teacher, Integer id_teacher, StudentServiceModel student, Integer id_student) {
        this.id = id;
        this.teacher = teacher;
        this.id_teacher = id_teacher;
        this.student = student;
        this.id_student = id_student;
    }

    public FavoriteServiceModel(TeacherServiceModel teacher, Integer id_teacher, StudentServiceModel student, Integer id_student) {
        this.teacher = teacher;
        this.id_teacher = id_teacher;
        this.student = student;
        this.id_student = id_student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TeacherServiceModel getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherServiceModel teacher) {
        this.teacher = teacher;
    }

    public Integer getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

    public StudentServiceModel getStudent() {
        return student;
    }

    public void setStudent(StudentServiceModel student) {
        this.student = student;
    }

    public Integer getId_student() {
        return id_student;
    }

    public void setId_student(Integer id_student) {
        this.id_student = id_student;
    }
}
