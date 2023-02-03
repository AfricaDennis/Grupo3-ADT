package com.reto2.grupo3.model.Opinion;

import com.reto2.grupo3.model.Student.StudentServiceModel;
import com.reto2.grupo3.model.Teacher.TeacherServiceModel;

public class OpinionPostRequest {
    private TeacherServiceModel teacher;
    private Integer id_teacher;
    private StudentServiceModel student;
    private Integer id_student;
    private Integer id;
    private String assesment;
    private String date;
    private String opinion;

    public OpinionPostRequest(){
    }

    public OpinionPostRequest(TeacherServiceModel teacher, Integer id_teacher, StudentServiceModel student, Integer id_student, String assesment, String date, String opinion) {
        this.teacher = teacher;
        this.id_teacher = id_teacher;
        this.student = student;
        this.id_student = id_student;
        this.assesment = assesment;
        this.date = date;
        this.opinion = opinion;
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

    public String getAssesment() {
        return assesment;
    }

    public void setAssesment(String assesment) {
        this.assesment = assesment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}