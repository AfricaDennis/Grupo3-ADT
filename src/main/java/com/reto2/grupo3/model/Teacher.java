package com.reto2.grupo3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id ", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_teacher_id"))
    private User user;
    @Column(length = 50)
    private String location;
    @Column(length = 50)
    private String shift;
    @Column(length = 5000)
    private String photo;


    @OneToMany(mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Opinion> opinions;

    public Teacher() {
    }

    public Teacher(User user, String location, String shift, String photo, List<Favorite> favorites, List<Opinion> opinions) {
        this.user = user;
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.favorites = favorites;
        this.opinions = opinions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    public List<Opinion> getOpinions() {
        return opinions;
    }

    public void setOpinions(List<Opinion> opinions) {
        this.opinions = opinions;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "user=" + user +
                ", location='" + location + '\'' +
                ", shift='" + shift + '\'' +
                ", photo='" + photo + '\'' +
                ", favorites=" + favorites +
                ", opinions=" + opinions +
                '}';
    }
}
