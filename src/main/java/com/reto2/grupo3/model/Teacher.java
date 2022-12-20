package com.reto2.grupo3.model;

import jakarta.persistence.*;

@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String location;
    @Column(length = 50)
    private String shift;
    @Column(length = 5000)
    private String photo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id ", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_teacher_id"))
    private User user;

    public Teacher() {
    }
    public Teacher(Integer id, String location, String shift, String photo, User user) {
        this.id = id;
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.user = user;
    }

    public Teacher(String location, String shift, String photo, User user) {
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", shift='" + shift + '\'' +
                ", photo='" + photo + '\'' +
                ", user=" + user +
                '}';
    }
}
