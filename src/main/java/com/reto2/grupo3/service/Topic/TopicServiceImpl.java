package com.reto2.grupo3.service.Topic;

import com.reto2.grupo3.model.Teacher.Teacher;
import com.reto2.grupo3.model.Teacher.TeacherServiceModel;
import com.reto2.grupo3.model.Topic.Topic;
import com.reto2.grupo3.model.Topic.TopicPostRequest;
import com.reto2.grupo3.model.Topic.TopicServiceModel;
import com.reto2.grupo3.repository.TopicRepository;
import com.reto2.grupo3.service.Teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;
    @Autowired
    TeacherService teacherService;

    @Override
    public List<TopicServiceModel> getAll() {
        Iterable<Topic> topics = topicRepository.findAll();
        List<TopicServiceModel> response = new ArrayList<>();

        for (Topic topic : topics) {
            TeacherServiceModel teacher = teacherService.getTeacher(topic.getIdTeacher());
            response.add(
                    new TopicServiceModel(
                            topic.getId(),
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
                            topic.getName(),
                            topic.getIdTeacher()
                    )
            );
        }

        return response;
    }

    @Override
    public TopicServiceModel getTopic(Integer id) {
        Topic topic = topicRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe esa id de la asignatura"));

        TeacherServiceModel teacher = teacherService.getTeacher(topic.getIdTeacher());
        TopicServiceModel response = new TopicServiceModel(
                topic.getId(),
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
                topic.getName(),
                topic.getIdTeacher()
        );

        return response;
    }

    @Override
    public TopicServiceModel createTopic(TopicPostRequest topicPostRequest) {
        TeacherServiceModel teacherServiceModel = null;
        if(topicPostRequest.getId_teacher() != null){
            teacherServiceModel = teacherService.getTeacher(topicPostRequest.getId_teacher());
        }

        Topic topic = new Topic(
                topicPostRequest.getId(),
                new Teacher(
                        teacherServiceModel.getId(),
                        teacherServiceModel.getName(),
                        teacherServiceModel.getSurname(),
                        teacherServiceModel.getPassword(),
                        teacherServiceModel.getEmail(),
                        teacherServiceModel.getPhone(),
                        teacherServiceModel.getLocation(),
                        teacherServiceModel.getShift(),
                        teacherServiceModel.getPhoto(),
                        teacherServiceModel.getDescription(),
                        teacherServiceModel.getOpinions()
                ),
                topicPostRequest.getName(),
                topicPostRequest.getId_teacher()
        );

        Topic queryTopic = topicRepository.save(topic);
        TopicServiceModel response = new TopicServiceModel(
                queryTopic.getId(),
                teacherServiceModel,
                topic.getName(),
                topic.getIdTeacher()
        );

        return response;
    }

    @Override
    public TopicServiceModel updateTopic(Integer id, TopicPostRequest topicPostRequest) {
        TeacherServiceModel teacherServiceModel = null;
        if(topicPostRequest.getId_teacher() != null){
            teacherServiceModel = teacherService.getTeacher(topicPostRequest.getId_teacher());
        }
        Topic topic = topicRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe la asignatura")
        );

        if(topicPostRequest.getName() != null){
            topic.setName(topicPostRequest.getName());
        }
        if(topicPostRequest.getId_teacher() != null){
            topic.setIdTeacher(topicPostRequest.getId_teacher());
        }

        Topic queryTopic = topicRepository.save(topic);
        TopicServiceModel response = new TopicServiceModel(
                queryTopic.getId(),
                teacherServiceModel,
                queryTopic.getName(),
                queryTopic.getIdTeacher()
        );

        return response;
    }

    @Override
    public void deleteTopicById(Integer id) {
        topicRepository.deleteById(id);
    }
}
