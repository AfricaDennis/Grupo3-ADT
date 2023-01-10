package com.reto2.grupo3.service.Student;

import com.reto2.grupo3.model.Student.Student;
import com.reto2.grupo3.model.Student.StudentPostRequest;
import com.reto2.grupo3.model.Student.StudentServiceModel;
import com.reto2.grupo3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentServiceModel> getAll() {
        Iterable<Student> students = studentRepository.findAll();
        List<StudentServiceModel> response = new ArrayList<>();

        for(Student student : students){
            response.add(
                    new StudentServiceModel(
                            student.getId(),
                            student.getName(),
                            student.getSurname(),
                            student.getPassword(),
                            student.getEmail(),
                            student.getPhone(),
                            student.getFavorites(),
                            student.getOpinions()
                    )
            );
        }
        return response;
    }

    @Override
    public StudentServiceModel getStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe alumno"));

        StudentServiceModel response = new StudentServiceModel(
                student.getId(),
                student.getName(),
                student.getSurname(),
                student.getPassword(),
                student.getEmail(),
                student.getPhone(),
                student.getFavorites(),
                student.getOpinions()
        );
        return response;
    }

    @Override
    public StudentServiceModel createStudent(StudentPostRequest studentPostRequest) {
        Student student = new Student(
                studentPostRequest.getId(),
                studentPostRequest.getName(),
                studentPostRequest.getSurname(),
                studentPostRequest.getPassword(),
                studentPostRequest.getEmail(),
                studentPostRequest.getPhone(),
                studentPostRequest.getFavorites(),
                studentPostRequest.getOpinions()
        );

        Student queryStudent = studentRepository.save(student);
        StudentServiceModel response = new StudentServiceModel(
                queryStudent.getId(),
                queryStudent.getName(),
                queryStudent.getSurname(),
                queryStudent.getPassword(),
                queryStudent.getEmail(),
                queryStudent.getPhone(),
                queryStudent.getFavorites(),
                queryStudent.getOpinions()
        );

        return response;
    }

    @Override
    public StudentServiceModel updateStudent(Integer id, StudentPostRequest studentPostRequest) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el profesor")
        );

        if(studentPostRequest.getId() != null){
            student.setId(studentPostRequest.getId());
        }
        if(studentPostRequest.getName() != null){
            student.setName(studentPostRequest.getName());
        }
        if(studentPostRequest.getSurname() != null){
            student.setSurname(studentPostRequest.getSurname());
        }
        if(studentPostRequest.getPassword() != null){
            student.setPassword(studentPostRequest.getPassword());
        }
        if(studentPostRequest.getEmail() != null){
            student.setEmail(studentPostRequest.getEmail());
        }
        if(studentPostRequest.getPhone() != null){
            student.setPhone(studentPostRequest.getPhone());
        }
        if(studentPostRequest.getFavorites() != null){
            student.setFavorites(studentPostRequest.getFavorites());
        }
        if(studentPostRequest.getOpinions() != null){
            student.setOpinions(studentPostRequest.getOpinions());
        }


        Student queryStudent = studentRepository.save(student);
        StudentServiceModel response = new StudentServiceModel(
                queryStudent.getId(),
                queryStudent.getName(),
                queryStudent.getSurname(),
                queryStudent.getPassword(),
                queryStudent.getEmail(),
                queryStudent.getPhone(),
                queryStudent.getFavorites(),
                queryStudent.getOpinions()
        );

        return response;
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
