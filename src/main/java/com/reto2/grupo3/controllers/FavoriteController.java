package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.*;
import com.reto2.grupo3.repository.FavoriteRepository;
import com.reto2.grupo3.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorites")
    public ResponseEntity<List<FavoriteServiceModel>> getFavorites(){
        return new ResponseEntity<>(favoriteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/favorites/{id}")
    public ResponseEntity<FavoriteServiceModel> getFavoritesById(@PathVariable("id") Integer id){
        return new ResponseEntity<FavoriteServiceModel>(favoriteService.getFavorite(id), HttpStatus.OK);
    }

    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<?> deleteFavoritesById(@PathVariable("id") Integer id) {
        try {
            favoriteService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe el favorito");
        }
    }
    @PostMapping("/favorites")
    public ResponseEntity<FavoriteServiceModel> createEmployee(@RequestBody FavoritePostRequest favoritePostRequest) {
        return new ResponseEntity<>(favoriteService.create(favoritePostRequest), HttpStatus.OK);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<FavoriteServiceModel> updateEmployeesById(@PathVariable("id") Integer id,
                                                                    @RequestBody FavoritePostRequest favoritePostRequest) {
        return new ResponseEntity<FavoriteServiceModel>(favoriteService.update(id, favoritePostRequest), HttpStatus.OK);
    }

}
