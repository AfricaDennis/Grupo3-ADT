package com.reto2.grupo3.model.Teacher;

import com.reto2.grupo3.model.Favorite.Favorite;
import com.reto2.grupo3.model.Opinion.Opinion;
import com.reto2.grupo3.model.User.User;

import java.util.List;

public class TeacherServiceModel {
    private User user;
    private String location;
    private String shift;
    private String photo;
    private List<Favorite> favorites;
    private List<Opinion> opinions;

    public TeacherServiceModel() {
    }

    public TeacherServiceModel(User user, String location, String shift, String photo, List<Favorite> favorites, List<Opinion> opinions) {
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
        return "TeacherServiceModel{" +
                "user=" + user +
                ", location='" + location + '\'' +
                ", shift='" + shift + '\'' +
                ", photo='" + photo + '\'' +
                ", favorites=" + favorites +
                ", opinions=" + opinions +
                '}';
    }
}
