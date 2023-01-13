package com.reto2.grupo3.service.Topic;

import com.reto2.grupo3.model.Topic.TopicPostRequest;
import com.reto2.grupo3.model.Topic.TopicServiceModel;

import java.util.List;

public interface TopicService {
    List<TopicServiceModel> getAll();
    TopicServiceModel getTopic(Integer id);
    TopicServiceModel createTopic (TopicPostRequest topicPostRequest);
    TopicServiceModel updateTopic (Integer id, TopicPostRequest topicPostRequest);
    void deleteTopicById(Integer id);

}
