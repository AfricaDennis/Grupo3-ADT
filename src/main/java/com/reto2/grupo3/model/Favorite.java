package com.reto2.grupo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="favorites")
public class Favorite {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher", foreignKey=@ForeignKey(name = "Fk_id_teacher"))
    @JsonManagedReference
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Teacher teacher;
}
