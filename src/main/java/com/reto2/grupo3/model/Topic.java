package com.reto2.grupo3.model;

public class Topic {

    Integer id;
    String name;
    Integer idTeacher;

    public Topic() {
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

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Topic(Integer id, String name, Integer idTeacher) {
        this.id = id;
        this.name = name;
        this.idTeacher = idTeacher;
    }
}
