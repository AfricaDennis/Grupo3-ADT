package com.reto2.grupo3.service;

import com.reto2.grupo3.model.*;
import com.reto2.grupo3.repository.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
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

        Student studentBD = favorite.getStudent();
        student = new StudentServiceModel(
                studentBD.getUser(),
                studentBD.getFavorites(),
                studentBD.getOpinions()
        );

        Teacher teacherBD = favorite.getTeacher();
        teacher = new TeacherServiceModel(
                teacherBD.getUser(),
                teacherBD.getLocation(),
                teacherBD.getShift(),
                teacherBD.getPhoto(),
                teacherBD.getFavorites(),
                teacherBD.getOpinions()
        );

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
    public FavoriteServiceModel create(FavoritePostRequest favoritePostRequest) {

        Favorite favorite = new Favorite(
                favoritePostRequest.getId(),
                null,
                favoritePostRequest.getId_teacher(),
                null,
                favoritePostRequest.getId_student()
        );

        Favorite queryFavorite = favoriteRepository.save(favorite);
        FavoriteServiceModel response = new FavoriteServiceModel(
                queryFavorite.getId(),
                null,
                queryFavorite.getId_teacher(),
                null,
                queryFavorite.getId_student()
        );
        return response;
    }

    @Override
    public FavoriteServiceModel update(Integer id, FavoritePostRequest favoritePostRequest) {
        Favorite favorite = favoriteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el favorito")
        );
        if(favoritePostRequest.getId_teacher() != null){
            favorite.setId_teacher(favoritePostRequest.getId_teacher());
        }
        if(favoritePostRequest.getId_student() != null){
            favorite.setId_student(favoritePostRequest.getId_student());
        }
        Favorite queryFavorite = favoriteRepository.save(favorite);
        FavoriteServiceModel response = new FavoriteServiceModel(
                queryFavorite.getId(),
                null,
                queryFavorite.getId_teacher(),
                null,
                queryFavorite.getId_student()
        );
        return response;
    }
    @Override
    public void deleteById(Integer id) {
        favoriteRepository.deleteById(id);
    }

}
