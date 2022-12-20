package com.reto2.grupo3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_student_id"))
    private User user;
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Favorite> favorites;
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Opinion> opinions;

    public Student() {
    }

    public Student(User user, List<Favorite> favorites, List<Opinion> opinions) {
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
        return "Student{" +
                "user=" + user +
                ", favorites=" + favorites +
                ", opinions=" + opinions +
                '}';
    }
}
