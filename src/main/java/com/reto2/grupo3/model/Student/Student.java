package com.reto2.grupo3.model.Student;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.reto2.grupo3.model.Favorite.Favorite;
import com.reto2.grupo3.model.Opinion.Opinion;
import com.reto2.grupo3.model.User.User;
import jakarta.persistence.*;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name="user_id")
@Table(name="students")
public class Student extends User{
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonManagedReference(value = "favorite_student")
    private List<Favorite> favorites;
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonManagedReference(value = "opinion_student")
    private List<Opinion> opinions;

    public Student() {
    }

    public Student( List<Favorite> favorites, List<Opinion> opinions) {
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
        return "Student{" +
                ", favorites=" + favorites +
                ", opinions=" + opinions +
                '}';
    }
}
