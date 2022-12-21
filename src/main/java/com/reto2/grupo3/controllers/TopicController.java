package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.Topic.Topic;
import com.reto2.grupo3.model.Topic.TopicServiceModel;
import com.reto2.grupo3.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class TopicController {

    @Autowired
    private TopicRepository TopicRepository;

    @GetMapping("/topics")
    public ResponseEntity<List<TopicServiceModel>>getTopic(){
        Iterable<Topic> Topic = TopicRepository.findAll();
        List<TopicServiceModel> response = new ArrayList<TopicServiceModel>();

        for(Topic topic : Topic){
            response.add(
                    new TopicServiceModel(
                            topic.getId(),
                        null,
                            topic.getIdTeacher()

                    )
            );
        }
        return new ResponseEntity<List<TopicServiceModel>>(response, HttpStatus.OK);

    }

}
