package com.reto2.grupo3.service.Favorite;

import com.reto2.grupo3.model.Favorite.FavoritePostRequest;
import com.reto2.grupo3.model.Favorite.FavoriteServiceModel;

import java.util.List;

public interface FavoriteService {
    List<FavoriteServiceModel> getAll();
    FavoriteServiceModel getFavorite(Integer id);
    FavoriteServiceModel createFavorite(FavoritePostRequest favoritePostRequest);
    FavoriteServiceModel updateFavorite(Integer id, FavoritePostRequest favoritePostRequest);
    void deleteFavoriteById(Integer id);
}
