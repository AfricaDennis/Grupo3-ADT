package com.reto2.grupo3.repository;

import com.reto2.grupo3.model.Favorite;
import com.reto2.grupo3.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
