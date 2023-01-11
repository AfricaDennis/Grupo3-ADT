package com.reto2.grupo3.model.User;

public class UserPostRequest {
    private Integer id;
    private boolean admin;
    private String email;
    private String name;
    private String surname;
    private String password;
    private String phone;

    public UserPostRequest(){
    }

    public UserPostRequest(Integer id, boolean admin, String email, String name, String surname, String password, String phone) {
        this.id = id;
        this.admin = admin;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
