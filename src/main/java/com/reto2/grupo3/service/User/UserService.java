package com.reto2.grupo3.service.User;

import com.reto2.grupo3.auth.exception.UserCantCreateException;
import com.reto2.grupo3.model.User.User;
import com.reto2.grupo3.model.User.UserPostRequest;
import com.reto2.grupo3.model.User.UserServiceModel;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface UserService {
    List<UserServiceModel> getALl();
    UserServiceModel getUser(Integer id);
    UserServiceModel createUser(UserPostRequest userPostRequest);
    UserServiceModel updateUser(Integer id, UserPostRequest userPostRequest);
    void deleteUserById(Integer id);
    User signUp(User user) throws UserCantCreateException;
    UserServiceModel enviarEmail(String email);
    UserServiceModel updateUserPass(Integer id, UserPostRequest userPostRequest);
}
