package com.reto2.grupo3.model.Topic;

import com.reto2.grupo3.model.Teacher.TeacherServiceModel;

public class TopicServiceModel {

    private Integer id;
    private TeacherServiceModel teacher;
    private String name;
    private Integer id_teacher;

    public TopicServiceModel() {
    }
    public TopicServiceModel(Integer id, TeacherServiceModel teacher, String name, Integer id_teacher) {
        this.id = id;
        this.teacher = teacher;
        this.name = name;
        this.id_teacher = id_teacher;
    }

    public TopicServiceModel(TeacherServiceModel teacher, String name, Integer id_teacher) {
        this.teacher = teacher;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

    @Override
    public String toString() {
        return "TopicServiceModel{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", name='" + name + '\'' +
                ", id_teacher=" + id_teacher +
                '}';
    }
}
