package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.Topic.Topic;
import com.reto2.grupo3.model.Topic.TopicPostRequest;
import com.reto2.grupo3.model.Topic.TopicServiceModel;
import com.reto2.grupo3.repository.TopicRepository;
import com.reto2.grupo3.service.Topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public ResponseEntity<List<TopicServiceModel>>getTopics(){
        return new ResponseEntity<>(topicService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/topics/{id}")
    public ResponseEntity<TopicServiceModel> getTopicById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(topicService.getTopic(id), HttpStatus.OK);
    }
    @PostMapping(value = "/topics", consumes = {"application/json"})
    public ResponseEntity<TopicServiceModel> createTopic(@RequestBody TopicPostRequest topicPostRequest){
        return new ResponseEntity<>(topicService.createTopic(topicPostRequest), HttpStatus.CREATED);
    }
    @PutMapping("/topics/{id}")
    public ResponseEntity<TopicServiceModel> updateTopicById(@PathVariable("id") Integer id, @RequestBody TopicPostRequest topicPostRequest){
        return new ResponseEntity<>(topicService.updateTopic(id, topicPostRequest), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/topics/{id}")
    public ResponseEntity<?> deleteTopicById(@PathVariable("id") Integer id){
        try{
            topicService.deleteTopicById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe el asignatura");
        }
    }

}
