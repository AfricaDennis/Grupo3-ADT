package com.reto2.grupo3.model;

public class TopicPostRequest {

    private TeacherServiceModel teacher;
    private Integer id_teacher;

    public TopicPostRequest() {
    }

    public TopicPostRequest(TeacherServiceModel teacher, Integer id_teacher) {
        this.teacher = teacher;
        this.id_teacher = id_teacher;
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
