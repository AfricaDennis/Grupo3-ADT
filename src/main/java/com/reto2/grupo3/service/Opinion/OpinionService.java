package com.reto2.grupo3.service.Opinion;

import com.reto2.grupo3.model.Opinion.OpinionPostRequest;
import com.reto2.grupo3.model.Opinion.OpinionServiceModel;

import java.util.List;

public interface OpinionService {
    List<OpinionServiceModel> getAll();

    OpinionServiceModel getOpinion(Integer id);

    void deleteOpinionById(Integer id);

    OpinionServiceModel createOpinion(OpinionPostRequest opinionPostRequest);

    OpinionServiceModel updateOpinion(Integer id, OpinionPostRequest opinionPostRequest);

}