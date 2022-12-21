package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.Opinion;
import com.reto2.grupo3.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class OpinionController {
    @Autowired
    private OpinionRepository opinionRepository;

    @GetMapping("/opinions")
    public ResponseEntity<Iterable<Opinion>> getOpinions(){
        return new ResponseEntity<Iterable<Opinion>>(opinionRepository.findAll(), HttpStatus.OK);
    }


}
