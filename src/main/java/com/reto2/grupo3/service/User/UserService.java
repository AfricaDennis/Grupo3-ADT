package com.reto2.grupo3.service.User;

import com.reto2.grupo3.model.User.UserPostRequest;
import com.reto2.grupo3.model.User.UserServiceModel;

import java.util.List;

public interface UserService {
    List<UserServiceModel> getALl();
    UserServiceModel getUser(Integer id);
    UserServiceModel createUser(UserPostRequest userPostRequest);
    UserServiceModel updateUser(Integer id, UserPostRequest userPostRequest);
    void deleteUserById(Integer id);
}
