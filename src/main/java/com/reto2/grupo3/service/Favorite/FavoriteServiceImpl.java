package com.reto2.grupo3.service.Favorite;

import com.reto2.grupo3.model.Favorite.Favorite;
import com.reto2.grupo3.model.Favorite.FavoritePostRequest;
import com.reto2.grupo3.model.Favorite.FavoriteServiceModel;
import com.reto2.grupo3.model.Student.Student;
import com.reto2.grupo3.model.Student.StudentServiceModel;
import com.reto2.grupo3.model.Teacher.Teacher;
import com.reto2.grupo3.model.Teacher.TeacherServiceModel;
import com.reto2.grupo3.repository.FavoriteRepository;
import com.reto2.grupo3.service.Student.StudentService;
import com.reto2.grupo3.service.Teacher.TeacherService;
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
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @Override
    public List<FavoriteServiceModel> getAll() {
        Iterable<Favorite> favorites = favoriteRepository.findAll();
        List<FavoriteServiceModel> response = new ArrayList<>();

        for (Favorite favorite : favorites) {
            TeacherServiceModel teacher = teacherService.getTeacher(favorite.getId_teacher());
            StudentServiceModel student = studentService.getStudent(favorite.getId_student());
            response.add(
                    new FavoriteServiceModel(
                            favorite.getId(),
                            new TeacherServiceModel(
                                    teacher.getId(),
                                    teacher.getName(),
                                    teacher.getSurname(),
                                    teacher.getEmail(),
                                    teacher.getPhone(),
                                    teacher.getLocation(),
                                    teacher.getShift(),
                                    teacher.getPhoto(),
                                    teacher.getDescription()
                            ),
                            favorite.getId_teacher(),
                            new StudentServiceModel(
                                    student.getId(),
                                    student.getName(),
                                    student.getSurname(),
                                    student.getEmail(),
                                    student.getPhone()
                            ),
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

        TeacherServiceModel teacher = teacherService.getTeacher(favorite.getId_teacher());
        StudentServiceModel student = studentService.getStudent(favorite.getId_student());

        FavoriteServiceModel response = new FavoriteServiceModel(
                favorite.getId(),
                new TeacherServiceModel(
                        teacher.getId(),
                        teacher.getName(),
                        teacher.getSurname(),
                        teacher.getEmail(),
                        teacher.getPhone(),
                        teacher.getLocation(),
                        teacher.getShift(),
                        teacher.getPhoto(),
                        teacher.getDescription()
                ),
                favorite.getId_teacher(),
                new StudentServiceModel(
                        student.getId(),
                        student.getName(),
                        student.getSurname(),
                        student.getEmail(),
                        student.getPhone()
                ),
                favorite.getId_student()
        );
        return response;
    }

    @Override
    public FavoriteServiceModel createFavorite(FavoritePostRequest favoritePostRequest) {
        TeacherServiceModel teacherServiceModel = null;
        if (favoritePostRequest.getId_teacher() != null) {
            teacherServiceModel = teacherService.getTeacher(favoritePostRequest.getId_teacher());

        }
        StudentServiceModel studentServiceModel = null;
        System.out.println(favoritePostRequest.getId_student());
        if (favoritePostRequest.getId_student() != null) {
            studentServiceModel = studentService.getStudent(favoritePostRequest.getId_student());
        }

        Favorite favorite = new Favorite(
                new Teacher(
                        teacherServiceModel.getId(),
                        teacherServiceModel.getName(),
                        teacherServiceModel.getSurname(),
                        teacherServiceModel.getPassword(),
                        teacherServiceModel.getEmail(),
                        teacherServiceModel.getPhone(),
                        teacherServiceModel.getLocation(),
                        teacherServiceModel.getShift(),
                        teacherServiceModel.getPhoto(),
                        teacherServiceModel.getDescription(),
                        teacherServiceModel.getOpinions()
                ),
                favoritePostRequest.getId_teacher(),
                new Student(
                        studentServiceModel.getId(),
                        studentServiceModel.getName(),
                        studentServiceModel.getSurname(),
                        studentServiceModel.getPassword(),
                        studentServiceModel.getEmail(),
                        studentServiceModel.getPhone(),
                        studentServiceModel.getFavorites(),
                        studentServiceModel.getOpinions()
                ),
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
    public FavoriteServiceModel updateFavorite(Integer id, FavoritePostRequest favoritePostRequest) {

        TeacherServiceModel teacherServiceModel = null;
        if (favoritePostRequest.getId_teacher() != null) {
            teacherServiceModel = teacherService.getTeacher(favoritePostRequest.getId_teacher());

        }
        StudentServiceModel studentServiceModel = null;
        if (favoritePostRequest.getId_student() != null) {
            studentServiceModel = studentService.getStudent(favoritePostRequest.getId_student());
        }

        Favorite favorite = favoriteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el favorito")
        );

        if (favoritePostRequest.getId_teacher() != null) {
            favorite.setId_teacher(favoritePostRequest.getId_teacher());
        }
        if (favoritePostRequest.getId_student() != null) {
            favorite.setId_student(favoritePostRequest.getId_student());
        }
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
    public void deleteFavoriteById(Integer id) {
        favoriteRepository.deleteById(id);
    }

}
