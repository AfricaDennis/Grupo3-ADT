package com.reto2.grupo3.service;

import com.reto2.grupo3.model.FavoritePostRequest;
import com.reto2.grupo3.model.FavoriteServiceModel;

import java.util.List;

public interface FavoriteService {
    List<FavoriteServiceModel> getAll();
    FavoriteServiceModel getFavorite(Integer id);
    void deleteById(Integer id);
    FavoriteServiceModel create(FavoritePostRequest favoritePostRequest);
    FavoriteServiceModel update(Integer id, FavoritePostRequest favoritePostRequest);
}
