package com.reto2.grupo3.model;

public class TopicServiceModel {

    private Integer id;
    private TeacherServiceModel teacher;
    private Integer id_teacher;

    public TopicServiceModel(Integer id, TeacherServiceModel teacher, Integer id_teacher) {
        this.id = id;
        this.teacher = teacher;
        this.id_teacher = id_teacher;
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
}
