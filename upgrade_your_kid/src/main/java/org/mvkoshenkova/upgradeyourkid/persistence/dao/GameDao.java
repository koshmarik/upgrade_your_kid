package org.mvkoshenkova.upgradeyourkid.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import org.mvkoshenkova.upgradeyourkid.persistence.entity.Game;

import java.util.List;

/**
 * Created by Mariya Koshenkova on 20.03.18.
 */
@Dao
public interface GameDao {

    @Query("select * from game where category = :category")
    List<Game> findAllByCategory(int category);

    @Insert
    void insertGame(Game game);
}
