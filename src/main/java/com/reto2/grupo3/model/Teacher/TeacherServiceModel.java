package com.reto2.grupo3.model.Teacher;

import com.reto2.grupo3.model.Favorite.Favorite;
import com.reto2.grupo3.model.Opinion.Opinion;
import com.reto2.grupo3.model.User.User;

import java.util.List;

public class TeacherServiceModel extends User{

    private String location;
    private String shift;
    private String photo;
    private List<Favorite> favorites;
    private List<Opinion> opinions;
    private  String description;

    public TeacherServiceModel() {
    }

    public TeacherServiceModel(String location, String shift, String photo, List<Favorite> favorites, List<Opinion> opinions, String description) {
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.favorites = favorites;
        this.opinions = opinions;
        this.description = description;
    }



    public TeacherServiceModel(Integer id, String name, String surname, String password, String email, String phone, String location, String shift, String photo, List<Favorite> favorites, List<Opinion> opinions, String description) {
        super(id, name, surname, password, email, phone);
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.favorites = favorites;
        this.opinions = opinions;
        this.description = description;
    }
    public TeacherServiceModel(Integer id, String name, String surname, String email, String phone, String location, String shift, String photo, List<Favorite> favorites, List<Opinion> opinions, String description) {
        super(id, name, surname, email, phone);
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.favorites = favorites;
        this.opinions = opinions;
        this.description = description;
    }

    public TeacherServiceModel(Integer id, String name, String surname, String email, String phone, String location, String shift, String photo, String description) {
        super(id, name, surname, email, phone);
        this.location = location;
        this.shift = shift;
        this.photo = photo;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TeacherServiceModel{" +
                "location='" + location + '\'' +
                ", shift='" + shift + '\'' +
                ", photo='" + photo + '\'' +
                ", favorites=" + favorites +
                ", opinions=" + opinions +
                ", description='" + description + '\'' +
                '}';
    }
}
