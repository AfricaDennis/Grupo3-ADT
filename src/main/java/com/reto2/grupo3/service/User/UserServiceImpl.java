package com.reto2.grupo3.service.User;

import com.reto2.grupo3.model.User.User;
import com.reto2.grupo3.model.User.UserPostRequest;
import com.reto2.grupo3.model.User.UserServiceModel;
import com.reto2.grupo3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserServiceModel> getALl() {
        Iterable<User> user = userRepository.findAll();
        List<UserServiceModel> response = new ArrayList<>();

        for(User users:user){
            response.add(
                    new UserServiceModel(
                            users.getId(),
                            users.getName(),
                            users.getSurname(),
                            users.getPassword(),
                            users.getEmail(),
                            users.getPhone(),
                            users.isAdmin()
                    )
            );
        }
        return response;
    }

    @Override
    public UserServiceModel getUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT, "El usuario no existe"));

        UserServiceModel response = new UserServiceModel(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                user.isAdmin()
        );

        return response;
    }

    @Override
    public UserServiceModel createUser(UserPostRequest userPostRequest) {
        User user = new User(
                userPostRequest.getName(),
                userPostRequest.getSurname(),
                userPostRequest.getPassword(),
                userPostRequest.getEmail(),
                userPostRequest.getPhone()
        );

        User queryUser = userRepository.save(user);
        UserServiceModel response = new UserServiceModel(
                queryUser.getName(),
                queryUser.getSurname(),
                queryUser.getPassword(),
                queryUser.getEmail(),
                queryUser.getPhone()
        );
        return response;
    }

    @Override
    public UserServiceModel updateUser(Integer id, UserPostRequest userPostRequest) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.CONFLICT, "No existe el usuario")
        );

        if(userPostRequest.getName() != null){
            user.setName(userPostRequest.getName());
        }

        if(userPostRequest.getSurname() != null){
            user.setSurname(userPostRequest.getSurname());
        }

        if(userPostRequest.getPassword() != null){
            user.setPassword(userPostRequest.getPassword());
        }

        if(userPostRequest.getEmail() != null){
            user.setEmail(userPostRequest.getEmail());
        }

        if(userPostRequest.getPhone() != null){
            user.setPhone(userPostRequest.getPhone());
        }

        User queryUser = userRepository.save(user);
        UserServiceModel response = new UserServiceModel(
                queryUser.getName(),
                queryUser.getSurname(),
                queryUser.getPassword(),
                queryUser.getEmail(),
                queryUser.getPhone()
        );
        return response;
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
