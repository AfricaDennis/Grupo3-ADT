package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.FavoriteServiceModel;
import com.reto2.grupo3.model.StudentServiceModel;
import com.reto2.grupo3.model.TeacherServiceModel;
import com.reto2.grupo3.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api")
public class FavoriteController {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @GetMapping("/favorites")
    public ResponseEntity<List<FavoriteServiceModel>> getFavorites(){
        return null;
    }

    @GetMapping("/favorites/{id}")
    public ResponseEntity<FavoriteServiceModel> getFavoritesById(@PathVariable("id") Integer id){
        Favorite favorite = favoriteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe favorito"));
        StudentServiceModel student = null;
        TeacherServiceModel teacher = null;

        FavoriteServiceModel response = new FavoriteServiceModel(
                favorite.getId(),
                teacher,
                favorite.getId_teacher(),
                student,
                favorite.getId_student()
        );

        return new ResponseEntity<FavoriteServiceModel>(response, HttpStatus.OK);
    }
}
