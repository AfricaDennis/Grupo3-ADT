package com.reto2.grupo3.repository;

import com.reto2.grupo3.model.Favorite.Favorite;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {
}
