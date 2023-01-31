package com.reto2.grupo3.auth.model;

public class AuthResponse {
    private Integer id;
    private String email;
    private boolean admin;
    private String accesToken;

    public AuthResponse() {}

    public AuthResponse(Integer id, String email) {
        super();
        this.id = id;
        this.email = email;
    }

    public AuthResponse(Integer id, String email, String accesToken) {
        super();
        this.id = id;
        this.email = email;
        this.accesToken = accesToken;
    }
    public AuthResponse(Integer id, String email, String accesToken,boolean admin) {
        super();
        this.id = id;
        this.email = email;
        this.accesToken = accesToken;
        this.admin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccesToken() {
        return accesToken;
    }

    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", accesToken='" + accesToken + '\'' +
                '}';
    }
}