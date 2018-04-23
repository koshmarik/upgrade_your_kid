package org.mvkoshenkova.upgradeyourkid.ui.adapter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import org.mvkoshenkova.upgradeyourkid.persistence.entity.Favorite;
import org.mvkoshenkova.upgradeyourkid.persistence.entity.Game;
import org.mvkoshenkova.upgradeyourkid.persistence.enums.Category;
import org.mvkoshenkova.upgradeyourkid.persistence.repository.FavoriteRepository;
import org.mvkoshenkova.upgradeyourkid.persistence.repository.GameRepository;

import java.util.List;

/**
 * Created by Mariya Koshenkova on 01.04.18.
 */

public class GameViewModel extends AndroidViewModel {

    private GameRepository gameRepository;
    private FavoriteRepository favoriteRepository;

    public GameViewModel(@NonNull Application application) {
        super(application);
        gameRepository = new GameRepository(application);
        favoriteRepository = new FavoriteRepository(application);
    }

    public LiveData<List<Game>> getGamesByCategory(Category category) {
        return gameRepository.getGamesByCategory(category);
    }

    public Game getGameById(int id) {
        return gameRepository.getGameById(id);
    }

    public LiveData<List<Favorite>> getFavorites(){
        return favoriteRepository.getAllFavorites();
    }

    public void insertFavorite(int gameId){
        favoriteRepository.addFavorite(gameId);
    }

    public void deleteFavorite(int gameId){
        favoriteRepository.deleteFavorite(gameId);
    }
}
