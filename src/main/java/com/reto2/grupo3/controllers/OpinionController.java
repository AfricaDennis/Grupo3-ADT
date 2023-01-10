package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.Opinion.OpinionServiceModel;
import com.reto2.grupo3.model.Opinion.OpinionPostRequest;
import com.reto2.grupo3.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/opinion/{id}")
    public ResponseEntity<OpinionServiceModel> getOpinionsById(@PathVariable("id") Integer id){
        return new ResponseEntity<OpinionServiceModel>(opinionService.getOpinion(id), HttpStatus.OK);
    }

    @PostMapping(value ="/opinions", consumes = {"application/json"})
    public ResponseEntity<OpinionServiceModel> createOpinion(@RequestBody OpinionPostRequest opinionPostRequest){
        return new ResponseEntity<OpinionServiceModel>(opinionService.createOpinion(opinionPostRequest),HttpStatus.CREATED);
    }

    @PutMapping("/opinion/{id}")
    public ResponseEntity<OpinionServiceModel> updateOpinionById(@PathVariable("id") Integer id, @RequestBody OpinionPostRequest opinionPostRequest){
        return new ResponseEntity<OpinionServiceModel>(opinionService.updateOpinion(id, opinionPostRequest), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/opinion/{id}")
    public ResponseEntity<?> deleteOpinionByID(@PathVariable("id") Integer id) {
        try{
            opinionService.deleteOpinionById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe la opinion");
        }
    }

}
