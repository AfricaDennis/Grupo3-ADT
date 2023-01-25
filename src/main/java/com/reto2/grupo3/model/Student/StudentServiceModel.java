package com.reto2.grupo3.model.Student;

import com.reto2.grupo3.model.Favorite.Favorite;
import com.reto2.grupo3.model.Opinion.Opinion;
import com.reto2.grupo3.model.User.User;

import java.util.List;

public class StudentServiceModel extends User {
    private List<Favorite> favorites;
    private List<Opinion> opinions;

    public StudentServiceModel() {
    }

    public StudentServiceModel(Integer id, String name, String surname, String email, String phone) {
        super(id, name, surname, email, phone);
    }

    public StudentServiceModel(Integer id, String name, String surname, String password, String email, String phone, List<Favorite> favorites, List<Opinion> opinions) {
        super(id, name, surname, password, email, phone);
        this.favorites = favorites;
        this.opinions = opinions;
    }

    public StudentServiceModel(List<Favorite> favorites, List<Opinion> opinions) {
        this.favorites = favorites;
        this.opinions = opinions;
    }

    public StudentServiceModel(Integer id, String name, String surname, String email, String phone, List<Favorite> favorites, List<Opinion> opinions) {
        super(id, name, surname, email, phone);
        this.favorites = favorites;
        this.opinions = opinions;
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
                ", favorites=" + favorites +
                ", opinions=" + opinions +
                '}';
    }
}
