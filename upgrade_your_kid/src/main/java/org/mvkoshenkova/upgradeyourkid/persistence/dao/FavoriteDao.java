package org.mvkoshenkova.upgradeyourkid.persistence.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import org.mvkoshenkova.upgradeyourkid.persistence.entity.Favorite;
import org.mvkoshenkova.upgradeyourkid.persistence.entity.FavoriteGame;

import java.util.List;

/**
 * Created by Mariya Koshenkova on 20.03.18.
 */
@Dao
public interface FavoriteDao {

    @Query("select * from favorite")
    LiveData<List<Favorite>> getAll();

    @Insert
    void insertFavorite(Favorite favorite);

    @Query("delete from favorite where game_id = :gameId")
    void deleteFavoriteByGameId(int gameId);

    @Query("select f.id favoriteId, f.game_id gameId, g.name, g.content, g.category, g.comment from favorite f " +
            "inner join game g on g.id = f.game_id")
    LiveData<List<FavoriteGame>> getAllFavoriteGames();
}
