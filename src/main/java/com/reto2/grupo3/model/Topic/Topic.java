package com.reto2.grupo3.model.Topic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reto2.grupo3.model.Teacher.Teacher;
import jakarta.persistence.*;

@Entity
@Table(name="topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher", foreignKey=@ForeignKey(name = "Fk_id_teacher"))
    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Teacher teacher;

  @Column(length = 50)
    String name;
    @Column(name="id_teacher", insertable = false, updatable = false)
    Integer idTeacher;

    public Topic() {
    }

    public Topic(Teacher teacher, String name, Integer idTeacher) {
        this.teacher = teacher;
        this.name = name;
        this.idTeacher = idTeacher;
    }

    public Topic(Integer id, Teacher teacher, String name, Integer idTeacher) {
        this.id = id;
        this.teacher = teacher;
        this.name = name;
        this.idTeacher = idTeacher;
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
