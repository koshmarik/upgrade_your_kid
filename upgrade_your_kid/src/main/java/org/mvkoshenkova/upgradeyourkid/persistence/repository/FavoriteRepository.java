package org.mvkoshenkova.upgradeyourkid.persistence.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import org.mvkoshenkova.upgradeyourkid.BasicApp;
import org.mvkoshenkova.upgradeyourkid.persistence.dao.FavoriteDao;
import org.mvkoshenkova.upgradeyourkid.persistence.entity.Favorite;

import java.util.List;

/**
 * Created by Mariya Koshenkova on 27.03.18.
 */

public class FavoriteRepository {

    private FavoriteDao favoriteDao;

    public FavoriteRepository(Application application) {
        favoriteDao = ((BasicApp)application).getDatabase().favoriteDao();
    }

    public LiveData<List<Favorite>> getAllFavorites(){
        return favoriteDao.getAll();
    }

    public void addFavorite(int gameId){
        favoriteDao.insertFavorite(new Favorite(gameId));
    }

    public void deleteFavorite(int gameId){
        favoriteDao.deleteFavoriteByGameId(gameId);
    }
}
