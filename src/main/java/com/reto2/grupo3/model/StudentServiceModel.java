package com.reto2.grupo3.model;

import java.util.List;

public class StudentServiceModel {

    private User user;
    private List<Favorite> favorites;
    private List<Opinion> opinions;

    public StudentServiceModel() {
    }

    public StudentServiceModel(User user, List<Favorite> favorites, List<Opinion> opinions) {
        this.user = user;
        this.favorites = favorites;
        this.opinions = opinions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "StudentServiceModel{" +
                "user=" + user +
                ", favorites=" + favorites +
                ", opinions=" + opinions +
                '}';
    }
}
