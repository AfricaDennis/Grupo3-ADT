package com.reto2.grupo3.controllers;

import com.reto2.grupo3.model.User.User;
import com.reto2.grupo3.model.User.UserPostRequest;
import com.reto2.grupo3.model.User.UserServiceModel;
import com.reto2.grupo3.repository.UserRepository;
import com.reto2.grupo3.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<UserServiceModel>> getUsers(){
        return new ResponseEntity<>(userService.getALl(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserServiceModel> getUserById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users", consumes = {"application/json"})
    public ResponseEntity<UserServiceModel> createUser(@RequestBody UserPostRequest userPostRequest){
        return new ResponseEntity<>(userService.createUser(userPostRequest), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserServiceModel> updateUserById(@PathVariable("id") Integer id, @RequestBody UserPostRequest userPostRequest){
        return new ResponseEntity<>(userService.updateUser(id,userPostRequest), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Integer id){
        try {
            userService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No existe el usuario");
        }
    }



    @PutMapping("/auth/enviarEmail/{email}")
    public ResponseEntity<UserServiceModel> updateUsuarioEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(userService.enviarEmail(email), HttpStatus.OK);
    }

}
