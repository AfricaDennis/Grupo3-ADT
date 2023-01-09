package com.reto2.grupo3.model.User;


import com.reto2.grupo3.model.Student.StudentServiceModel;
import com.reto2.grupo3.model.Teacher.TeacherServiceModel;

public class UserServiceModel {
    private Integer id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String phone;
    private StudentServiceModel student;
    private TeacherServiceModel teacher;

    public UserServiceModel() {
    }

    public UserServiceModel(Integer id, String name, String surname, String password, String email, String phone, StudentServiceModel student, TeacherServiceModel teacher) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.student = student;
        this.teacher = teacher;
    }

    public UserServiceModel(String name, String surname, String password, String email, String phone, StudentServiceModel student, TeacherServiceModel teacher) {
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

    public StudentServiceModel getStudent() {
        return student;
    }

    public void setStudent(StudentServiceModel student) {
        this.student = student;
    }

    public TeacherServiceModel getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherServiceModel teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "UserServiceModel{" +
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
