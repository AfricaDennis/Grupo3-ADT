package com.reto2.grupo3.service;

import com.reto2.grupo3.model.Favorite.FavoriteServiceModel;
import com.reto2.grupo3.model.Opinion.Opinion;
import com.reto2.grupo3.model.Opinion.OpinionPostRequest;
import com.reto2.grupo3.model.Opinion.OpinionServiceModel;
import com.reto2.grupo3.model.Student.Student;
import com.reto2.grupo3.model.Student.StudentServiceModel;
import com.reto2.grupo3.model.Teacher.Teacher;
import com.reto2.grupo3.model.Teacher.TeacherServiceModel;
import com.reto2.grupo3.repository.OpinionRepository;
import com.reto2.grupo3.repository.StudentRepository;
import com.reto2.grupo3.repository.TeacherRepository;
import com.reto2.grupo3.service.Student.StudentService;
import com.reto2.grupo3.service.Teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpinionServiceImpl implements OpinionService{
    @Autowired
    OpinionRepository opinionRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Override
    public List<OpinionServiceModel> getAll(){
        Iterable<Opinion> opinions = opinionRepository.findAll();
        List<OpinionServiceModel> response = new ArrayList<>();

        for (Opinion opinion : opinions){
            TeacherServiceModel teacher = teacherService.getTeacher(opinion.getId_teacher());
            StudentServiceModel student = studentService.getStudent(opinion.getId_students());
            response.add(
                    new OpinionServiceModel(
                            opinion.getId(),
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
                            opinion.getId_teacher(),
                            new StudentServiceModel(
                                    student.getId(),
                                    student.getName(),
                                    student.getSurname(),
                                    student.getEmail(),
                                    student.getPhone()
                            ),
                            opinion.getId_students(),
                            opinion.getAssesment(),
                            opinion.getDate(),
                            opinion.getOpinion()
                    )
            );
        }
        return response;
    }

    @Override
    public OpinionServiceModel getOpinion(Integer id) {
        Opinion opinion = opinionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe opinion"));
        TeacherServiceModel teacher = teacherService.getTeacher(opinion.getId_teacher());
        StudentServiceModel student = studentService.getStudent(opinion.getId_students());

        OpinionServiceModel response = new OpinionServiceModel(
                opinion.getId(),
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
                opinion.getId_teacher(),
                new StudentServiceModel(
                        student.getId(),
                        student.getName(),
                        student.getSurname(),
                        student.getEmail(),
                        student.getPhone()
                ),
                opinion.getId_students(),
                opinion.getAssesment(),
                opinion.getDate(),
                opinion.getOpinion()
        );
        return response;
    }

    @Override
    public OpinionServiceModel createOpinion(OpinionPostRequest opinionPostRequest) {
        TeacherServiceModel teacherServiceModel = null;
        if(opinionPostRequest.getId_teacher() != null){
            teacherServiceModel = teacherService.getTeacher(opinionPostRequest.getId_teacher());
        }

        StudentServiceModel studentServiceModel = null;
        if(opinionPostRequest.getId_student() != null){
            studentServiceModel = studentService.getStudent(opinionPostRequest.getId_student());
        }

        Opinion opinion = new Opinion(
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
                opinionPostRequest.getId_teacher(),
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
                opinionPostRequest.getId_student(),
                opinionPostRequest.getAssesment(),
                opinionPostRequest.getDate(),
                opinionPostRequest.getOpinion()
        );

        Opinion queryOpinion = opinionRepository.save(opinion);
        OpinionServiceModel response = new OpinionServiceModel(
                queryOpinion.getId(),
                teacherServiceModel,
                queryOpinion.getId_teacher(),
                studentServiceModel,
                queryOpinion.getId_students(),
                queryOpinion.getAssesment(),
                queryOpinion.getDate(),
                queryOpinion.getOpinion()
        );
        return response;
    }

    @Override
    public OpinionServiceModel updateOpinion(Integer id, OpinionPostRequest opinionPostRequest) {
        TeacherServiceModel teacherServiceModel = null;
        if(opinionPostRequest.getId_teacher() != null){
            teacherServiceModel = teacherService.getTeacher(opinionPostRequest.getId_teacher());
        }

        StudentServiceModel studentServiceModel =null;
        if(opinionPostRequest.getId_student() != null){
            studentServiceModel = studentService.getStudent(opinionPostRequest.getId_student());
        }

        Opinion opinion = opinionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe la opinion"));

        if (opinionPostRequest.getId_teacher() != null){
            opinion.setId_teacher(opinionPostRequest.getId_teacher());
        }

        if (opinionPostRequest.getId_student() != null){
            opinion.setId_students(opinionPostRequest.getId_student());
        }

        if (opinionPostRequest.getAssesment() != null){
            opinion.setAssesment(opinionPostRequest.getAssesment());
        }

        if (opinionPostRequest.getDate() != null){
            opinion.setDate(opinionPostRequest.getDate());
        }

        if (opinionPostRequest.getOpinion() != null){
            opinion.setOpinion(opinionPostRequest.getOpinion());
        }

        Opinion queryOpinion = opinionRepository.save(opinion);
        OpinionServiceModel response = new OpinionServiceModel(
                queryOpinion.getId(),
                teacherServiceModel,
                queryOpinion.getId_teacher(),
                studentServiceModel,
                queryOpinion.getId_students(),
                queryOpinion.getAssesment(),
                queryOpinion.getDate(),
                queryOpinion.getOpinion()
        );

        return response;
    }

    @Override
    public void deleteOpinionById(Integer id) {
        opinionRepository.deleteById(id);
    }

}
