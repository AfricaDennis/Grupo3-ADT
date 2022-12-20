package com.reto2.grupo3.service;

import com.reto2.grupo3.model.Favorite;
import com.reto2.grupo3.model.FavoriteServiceModel;
import com.reto2.grupo3.model.StudentServiceModel;
import com.reto2.grupo3.model.TeacherServiceModel;
import com.reto2.grupo3.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class FavoriteServiceImpl implements FavoriteService{
    @Autowired
    FavoriteRepository favoriteRepository;
    @Override
    public List<FavoriteServiceModel> getAll() {
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
        return response;
    }

    @Override
    public FavoriteServiceModel getFavorite(Integer id) {
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
        return response;
    }

    @Override
    public int createFavorite(FavoriteServiceModel favoriteServiceModel) {
        return 0;
    }

    @Override
    public int updateFavorite(FavoriteServiceModel favoriteServiceModel, Integer id) {
        return 0;
    }

    @Override
    public void deleteFavoriteById(Integer id) {
        favoriteRepository.deleteById(id);
    }
}
