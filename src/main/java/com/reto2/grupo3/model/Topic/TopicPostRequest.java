package com.reto2.grupo3.model.Topic;

import com.reto2.grupo3.model.Teacher.TeacherServiceModel;

public class TopicPostRequest {
    private Integer id;
    private String name;
    private TeacherServiceModel teacher;
    private Integer id_teacher;
    public TopicPostRequest() {
    }

    public TopicPostRequest(Integer id, String name, TeacherServiceModel teacher, Integer id_teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.id_teacher = id_teacher;
    }

    public TopicPostRequest(String name, TeacherServiceModel teacher, Integer id_teacher) {
        this.name = name;
        this.teacher = teacher;
        this.id_teacher = id_teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "TopicPostRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", id_teacher=" + id_teacher +
                '}';
    }
}
