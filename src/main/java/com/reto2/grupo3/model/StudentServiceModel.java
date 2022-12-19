package com.reto2.grupo3.model;

<<<<<<< HEAD
import java.util.List;

public class StudentServiceModel {

    private UserServiceModel user;
    private List<Favorite> favorites;
    private List<Opinion> opinions;

    public StudentServiceModel() {
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
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
=======
public class StudentServiceModel {
>>>>>>> 90ed6ff (Add modelService)
}
