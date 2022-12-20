package com.reto2.grupo3.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 5000)
    private String password;
    @Column(length = 50)
    private String email;
    @Column(length = 13)
    private String phone;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Student student;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    private Teacher teacher;


    public User() {
    }

    public User(Integer id, String name, String surname, String password, String email, String phone, Student student, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.student = student;
        this.teacher = teacher;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", student=" + student +
                ", teacher=" + teacher +
                '}';
    }
}
