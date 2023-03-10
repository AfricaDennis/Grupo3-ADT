package com.reto2.grupo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher", referencedColumnName = "user_id", foreignKey=@ForeignKey(name = "fk_teacher_favorites"))
    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Teacher teacher;

    @Column(name="id_teacher", insertable = false, updatable = false)
    private Integer id_teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_students", referencedColumnName = "user_id", foreignKey=@ForeignKey(name = "fk_student_favorites"))
    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Student student;

    @Column(name="id_students", insertable = false, updatable = false)
    private Integer id_students;

    public Favorite() {
    }

    public Favorite(Integer id, Teacher teacher, Integer id_teacher, Student student, Integer id_students) {
        this.id = id;
        this.teacher = teacher;
        this.id_teacher = id_teacher;
        this.student = student;
        this.id_students = id_students;
    }

    public Favorite(Teacher teacher, Integer id_teacher, Student student, Integer id_student) {
        this.teacher = teacher;
        this.id_teacher = id_teacher;
        this.student = student;
        this.id_students = id_student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Integer id_teacher) {
        this.id_teacher = id_teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getId_student() {
        return id_students;
    }

    public void setId_student(Integer id_students) {
        this.id_students = id_students;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", id_teacher=" + id_teacher +
                ", student=" + student +
                ", id_student=" + id_students +
                '}';
    }
}
