package com.reto2.grupo3.model.Teacher;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reto2.grupo3.model.Favorite.Favorite;
import com.reto2.grupo3.model.Opinion.Opinion;
import com.reto2.grupo3.model.User.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="user_id")
@Table(name="teachers")
public class Teacher extends User{
    @Column(length = 50)
    private String location;
    @Column(length = 50)
    private String shift;
    @Column(length = 5000)
    private String photo;
    @Column(length = 500)
    private String description;


    @OneToMany(mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonManagedReference(value = "favorite_teacher")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonManagedReference(value = "opinion_teacher")
    private List<Opinion> opinions;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String surname, String email, String phone, String location, String shift, String photo, String description, List<Favorite> favorites, List<Opinion> opinions) {
        super(id, name, surname, email, phone);
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.description = description;
        this.favorites = favorites;
        this.opinions = opinions;
    }

    public Teacher(String location, String shift, String photo, String description, List<Favorite> favorites, List<Opinion> opinions, String teacherPostRequestDescription) {
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.description = description;
        this.favorites = favorites;
        this.opinions = opinions;
    }

    public Teacher(Integer id, String name, String surname, String password, String email, String phone, String location, String shift, String photo, String description, List<Favorite> favorites, List<Opinion> opinions) {
        super(id, name, surname, password, email, phone);
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.description = description;
        this.favorites = favorites;
        this.opinions = opinions;
    }

    public Teacher(Integer id, String name, String surname, String password, String email, String phone, String location, String shift, String photo, String description, List<Opinion> opinions) {
        super(id, name, surname, password, email, phone);
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.description = description;
        this.opinions = opinions;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                "location='" + location + '\'' +
                ", shift='" + shift + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", favorites=" + favorites +
                ", opinions=" + opinions +
                '}';
    }
}
