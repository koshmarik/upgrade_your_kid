package org.mvkoshenkova.upgradeyourkid.ui.adapter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import org.mvkoshenkova.upgradeyourkid.persistence.entity.Game;
import org.mvkoshenkova.upgradeyourkid.persistence.enums.Category;
import org.mvkoshenkova.upgradeyourkid.persistence.repository.GameRepository;

import java.util.List;

/**
 * Created by Mariya Koshenkova on 01.04.18.
 */

public class GameViewModel extends AndroidViewModel {

    GameRepository gameRepository;

    public GameViewModel(@NonNull Application application) {
        super(application);
        gameRepository = new GameRepository(application);
    }

    public LiveData<List<Game>> getGamesByCategory(Category category) {
        return gameRepository.getGamesByCategory(category);
    }

    public Game getGameById(int id) {
        return gameRepository.getGameById(id);
    }
}
