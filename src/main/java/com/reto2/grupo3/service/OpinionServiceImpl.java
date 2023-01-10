package com.reto2.grupo3.service;

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
    TeacherRepository teacherRepository;
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<OpinionServiceModel> getAll(){
        Iterable<Opinion> opinions = opinionRepository.findAll();
        List<OpinionServiceModel> response = new ArrayList<>();

        for( Opinion opinion : opinions){
            Teacher teacher = teacherRepository.findById(opinion.getId_teacher()).get();
            Student student = studentRepository.findById(opinion.getId_students()).get();
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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe la opinion"));
        Teacher teacher = teacherRepository.findById(opinion.getId_teacher()).get();
        Student student = studentRepository.findById(opinion.getId_students()).get();

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
    public void deleteOpinionById(Integer id) {
        opinionRepository.deleteById(id);
    }

    @Override
    public OpinionServiceModel createOpinion(OpinionPostRequest opinionPostRequest) {
        Teacher teacher = null;
        TeacherServiceModel teacherServiceModel = null;
        if(opinionPostRequest.getId_teacher() != null) {
            teacher = teacherRepository.findById(opinionPostRequest.getId_teacher()).orElseThrow(
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

        if (opinionPostRequest.getId_student() != null) {
            student = studentRepository.findById(opinionPostRequest.getId_student()).orElseThrow(
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
        Opinion opinion = new Opinion(
                teacher,
                opinionPostRequest.getId_teacher(),
                student,
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
                opinionPostRequest.getAssesment(),
                opinionPostRequest.getDate(),
                opinionPostRequest.getOpinion()
        );
        return response;
    }

    @Override
    public OpinionServiceModel updateOpinion(Integer id, OpinionPostRequest opinionPostRequest) {

        Teacher teacher = null;
        TeacherServiceModel teacherServiceModel = null;
        if(opinionPostRequest.getId_teacher() != null){
            teacher = teacherRepository.findById(opinionPostRequest.getId_teacher()).orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe la opinion")
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
        if (opinionPostRequest.getId_student() != null) {
            student = studentRepository.findById(opinionPostRequest.getId_student()).orElseThrow(
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

        Opinion opinion = opinionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe la opinion")
        );

        if(opinionPostRequest.getId_teacher() != null){
            opinion.setId_teacher(opinionPostRequest.getId_teacher());
        }

        if(opinionPostRequest.getId_student() != null){
            opinion.setId_students(opinionPostRequest.getId_student());
        }

        opinion.setTeacher(teacher);
        opinion.setStudent(student);

        Opinion queryOpinion = opinionRepository.save(opinion);
        OpinionServiceModel response = new OpinionServiceModel(
                queryOpinion.getId(),
                teacherServiceModel,
                queryOpinion.getId_teacher(),
                studentServiceModel,
                queryOpinion.getId_students(),
                opinionPostRequest.getAssesment(),
                opinionPostRequest.getDate(),
                opinionPostRequest.getOpinion()
        );
        return response;
    }

}
