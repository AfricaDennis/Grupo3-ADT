package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.Favorite;
import com.reto2.grupo3.model.FavoriteServiceModel;
import com.reto2.grupo3.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class FavoriteController {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @GetMapping("/favorites")
    public ResponseEntity<List<FavoriteServiceModel>> getFavorites(){
        Iterable<Favorite> favorites = favoriteRepository.findAll();
        List<FavoriteServiceModel> response = new ArrayList<FavoriteServiceModel>();

        for(Favorite favorite : favorites){
            response.add(
                    new FavoriteServiceModel(
                         favorite.getId(),
                         null,
                            favorite.getId_teacher(),
                            null,
                            favorite.getId_student()
                    )
            );
        }
        return new ResponseEntity<List<FavoriteServiceModel>>(response, HttpStatus.OK);
    }
}
