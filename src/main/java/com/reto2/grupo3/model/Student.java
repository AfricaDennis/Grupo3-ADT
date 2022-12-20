package com.reto2.grupo3.model;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id", foreignKey=@ForeignKey(name = "fk_user"))
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Student() {
    }
    public Student(Long id, User user) {
        this.id = id;
        this.user = user;
    }
    public Student(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
