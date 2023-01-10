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
        List<FavoriteServiceModel> response = new ArrayList<>();

        for (Favorite favorite : favorites) {
            //Cuando tenga el servicio de teacher y student te cargo esta línea y llamo al servicio de cada uno
            Teacher teacher = teacherRepository.findById(favorite.getId_teacher()).get();
            Student student = studentRepository.findById(favorite.getId_student()).get();
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

        //Cuando tenga el servicio de teacher y student te cargo esta línea y llamo al servicio de cada uno
        Teacher teacher = teacherRepository.findById(favorite.getId_teacher()).get();
        Student student = studentRepository.findById(favorite.getId_student()).get();

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
        Teacher teacher = null;
        TeacherServiceModel teacherServiceModel = null;
        if (favoritePostRequest.getId_teacher() != null) {
            teacher = teacherRepository.findById(favoritePostRequest.getId_teacher()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el profesor")
            );
            teacherServiceModel = new TeacherServiceModel(
                    teacher.getId(),
                    teacher.getName(),
                    teacher.getSurname(),
                    teacher.getEmail(),
                    teacher.getPhone(),
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
        if (favoritePostRequest.getId_student() != null) {
            student = studentRepository.findById(favoritePostRequest.getId_student()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el alumno")
            );

            studentServiceModel = new StudentServiceModel(
                    student.getId(),
                    student.getName(),
                    student.getSurname(),
                    student.getEmail(),
                    student.getPhone()
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
    public FavoriteServiceModel updateFavorite(Integer id, FavoritePostRequest favoritePostRequest) {

        Teacher teacher = null;
        TeacherServiceModel teacherServiceModel = null;
        if (favoritePostRequest.getId_teacher() != null) {
            teacher = teacherRepository.findById(favoritePostRequest.getId_teacher()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el profesor")
            );
            teacherServiceModel = new TeacherServiceModel(
                    teacher.getId(),
                    teacher.getName(),
                    teacher.getSurname(),
                    teacher.getEmail(),
                    teacher.getPhone(),
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
        if (favoritePostRequest.getId_student() != null) {
            student = studentRepository.findById(favoritePostRequest.getId_student()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el alumno")
            );

            studentServiceModel = new StudentServiceModel(
                    student.getId(),
                    student.getName(),
                    student.getSurname(),
                    student.getEmail(),
                    student.getPhone()
            );
        }

        Favorite favorite = favoriteRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el favorito")
        );

        if(favoritePostRequest.getId_teacher() != null) {
            favorite.setId_teacher(favoritePostRequest.getId_teacher());
        }
        if(favoritePostRequest.getId_student() != null) {
            favorite.setId_student(favoritePostRequest.getId_student());
        }
        favorite.setTeacher(teacher);
        favorite.setStudent(student);

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
