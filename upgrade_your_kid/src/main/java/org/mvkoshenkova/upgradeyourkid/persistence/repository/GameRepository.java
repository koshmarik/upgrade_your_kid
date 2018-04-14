package org.mvkoshenkova.upgradeyourkid.persistence.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import org.mvkoshenkova.upgradeyourkid.BasicApp;
import org.mvkoshenkova.upgradeyourkid.persistence.dao.GameDao;
import org.mvkoshenkova.upgradeyourkid.persistence.entity.Game;
import org.mvkoshenkova.upgradeyourkid.persistence.enums.Category;

import java.util.List;

/**
 * Created by Mariya Koshenkova on 27.03.18.
 */

public class GameRepository {

    private GameDao gameDao;

    public GameRepository(Application application) {
        gameDao = ((BasicApp)application).getDatabase().gameDao();
    }

    public LiveData<List<Game>> getGamesByCategory(Category category) {
        if(category == null) {
            Log.e("error", "Category must be not null");
            return null;
        }
        return gameDao.findAllByCategory(category.id);
    }

    public int gamesCount(){
        return gameDao.gamesCount();
    }

    public Game getGameById(int id){
        return gameDao.findGameById(id);
    }
}
