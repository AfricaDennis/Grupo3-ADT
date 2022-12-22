package com.reto2.grupo3.service;

import com.reto2.grupo3.model.Opinion;
import com.reto2.grupo3.model.OpinionPostRequest;
import com.reto2.grupo3.model.OpinionServiceModel;

import java.util.List;

public interface OpinionService {
    List<OpinionServiceModel> getAll();
    OpinionServiceModel getOpinion(Integer id);
    void deleteById(Integer id);
    OpinionServiceModel create(OpinionPostRequest opinionPostRequest);
    OpinionServiceModel update(Integer id, OpinionPostRequest opinionPostRequest);
}
