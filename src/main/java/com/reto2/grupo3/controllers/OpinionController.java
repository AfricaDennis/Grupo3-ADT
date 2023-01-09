package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.Opinion.Opinion;
import com.reto2.grupo3.model.Opinion.OpinionServiceModel;
import com.reto2.grupo3.repository.OpinionRepository;
import com.reto2.grupo3.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class OpinionController {
    @Autowired
    private OpinionService opinionService;

    @GetMapping("/opinions")
    public ResponseEntity<List<OpinionServiceModel>> getOpinions(){
        return new ResponseEntity<>(opinionService.getAll(), HttpStatus.OK);
    }

}
