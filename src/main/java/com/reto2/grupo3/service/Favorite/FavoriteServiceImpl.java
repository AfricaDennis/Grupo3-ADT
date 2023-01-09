package com.reto2.grupo3.service.Favorite;

import com.reto2.grupo3.model.Favorite.Favorite;
import com.reto2.grupo3.model.Favorite.FavoritePostRequest;
import com.reto2.grupo3.model.Favorite.FavoriteServiceModel;
import com.reto2.grupo3.model.Student.Student;
import com.reto2.grupo3.model.Student.StudentServiceModel;
import com.reto2.grupo3.model.Teacher.Teacher;
import com.reto2.grupo3.model.Teacher.TeacherServiceModel;
import com.reto2.grupo3.repository.FavoriteRepository;
import com.reto2.grupo3.repository.StudentRepository;
import com.reto2.grupo3.repository.TeacherRepository;
import com.reto2.grupo3.service.Favorite.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    StudentRepository studentRepository;
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

        FavoriteServiceModel response = new FavoriteServiceModel(
                favorite.getId(),
                null,
                favorite.getId_teacher(),
                null,
                favorite.getId_student()
        );
        return response;
    }

    @Override
    public FavoriteServiceModel create(FavoritePostRequest favoritePostRequest) {
        Teacher teacher = null;
        TeacherServiceModel teacherServiceModel = null;
        if(favoritePostRequest.getId_teacher() != null) {
                teacher = teacherRepository.findById(favoritePostRequest.getId_teacher()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el profesor")
            );
            teacherServiceModel = new TeacherServiceModel(
                    teacher.getLocation(),
                    teacher.getShift(),
                    teacher.getPhoto(),
                    teacher.getFavorites(),
                    teacher.getOpinions(),
                    teacher.getDescription()
            );

        }
        Student student = null;
        StudentServiceModel studentServiceModel = null;
        if(favoritePostRequest.getId_student() != null) {
                student = studentRepository.findById(favoritePostRequest.getId_student()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el alumno")
            );

                studentServiceModel = new StudentServiceModel(
                        student.getFavorites(),
                        student.getOpinions()
                );
        }

        Favorite favorite = new Favorite(
                teacher,
                favoritePostRequest.getId_teacher(),
                student,
                favoritePostRequest.getId_student()
        );


        Favorite queryFavorite = favoriteRepository.save(favorite);
        FavoriteServiceModel response = new FavoriteServiceModel(
                queryFavorite.getId(),
                teacherServiceModel,
                queryFavorite.getId_teacher(),
                studentServiceModel,
                queryFavorite.getId_student()
        );

        return response;
    }

    @Override
    public FavoriteServiceModel update(Integer id, FavoritePostRequest favoritePostRequest) {

        Teacher teacher = null;
        TeacherServiceModel teacherServiceModel = null;
        if(favoritePostRequest.getId_teacher() != null) {
            teacher = teacherRepository.findById(favoritePostRequest.getId_teacher()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el profesor")
            );
            teacherServiceModel = new TeacherServiceModel(
                    teacher.getLocation(),
                    teacher.getShift(),
                    teacher.getPhoto(),
                    teacher.getFavorites(),
                    teacher.getOpinions(),
                    teacher.getDescription()
            );

        }
        Student student = null;
        StudentServiceModel studentServiceModel = null;
        if(favoritePostRequest.getId_student() != null) {
            student = studentRepository.findById(favoritePostRequest.getId_student()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el alumno")
            );

            studentServiceModel = new StudentServiceModel(
                    student.getFavorites(),
                    student.getOpinions()
            );
        }

        Favorite favorite = new Favorite(
                teacher,
                favoritePostRequest.getId_teacher(),
                student,
                favoritePostRequest.getId_student()
        );


        Favorite queryFavorite = favoriteRepository.save(favorite);
        FavoriteServiceModel response = new FavoriteServiceModel(
                queryFavorite.getId(),
                teacherServiceModel,
                queryFavorite.getId_teacher(),
                studentServiceModel,
                queryFavorite.getId_student()
        );

        return response;
    }
    @Override
    public void deleteById(Integer id) {
        favoriteRepository.deleteById(id);
    }

}
