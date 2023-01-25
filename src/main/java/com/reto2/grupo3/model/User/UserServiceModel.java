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
    private boolean student;
    private boolean teacher;

    private boolean admin;

    public UserServiceModel() {
    }

    public UserServiceModel(Integer id, String name, String surname, String password, String email, String phone, boolean student, boolean teacher) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.student = student;
        this.teacher = teacher;
    }

    public UserServiceModel(String name, String surname, String password, String email, String phone, boolean student, boolean teacher) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.student = student;
        this.teacher = teacher;
    }

    public UserServiceModel(Integer id, String name, String surname, String password, String email, String phone, boolean admin) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.admin = admin;
    }

    public UserServiceModel(String name, String surname, String password, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.phone = phone;
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

    public boolean getStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(boolean teacher) {
        this.teacher = teacher;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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
