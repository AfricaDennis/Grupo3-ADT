package com.reto2.grupo3.service;

import com.reto2.grupo3.model.Opinion;
import com.reto2.grupo3.model.OpinionPostRequest;
import com.reto2.grupo3.model.OpinionServiceModel;
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
        List<OpinionServiceModel> response = new ArrayList<OpinionServiceModel>();

        for( Opinion opinion : opinions){
            response.add(
                    new OpinionServiceModel(
                            opinion.getId(),
                            null,
                            opinion.getId_teacher(),
                            null,
                            opinion.getId_students(),
                            opinion.getDate(),
                            opinion.getAssesment(),
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
        OpinionServiceModel response = new OpinionServiceModel(
                opinion.getId(),
                null,
                opinion.getId_teacher(),
                null,
                opinion.getId_students(),
                opinion.getDate(),
                opinion.getAssesment(),
                opinion.getOpinion()
        );

        return response;
    }

    @Override
    public void deleteById(Integer id) {
        opinionRepository.deleteById(id);
    }

    @Override
    public OpinionServiceModel create(OpinionPostRequest opinionPostRequest) {
        return null;
    }

    @Override
    public OpinionServiceModel update(Integer id, OpinionPostRequest opinionPostRequest) {
        return null;
    }

}
