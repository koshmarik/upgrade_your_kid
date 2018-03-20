package org.mvkoshenkova.upgradeyourkid.persistence.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import org.mvkoshenkova.upgradeyourkid.persistence.entity.Favorite;

import java.util.List;

/**
 * Created by Mariya Koshenkova on 20.03.18.
 */
@Dao
public interface FavoriteDao {

    @Query("select * from Favorite")
    List<Favorite> getAll();

    @Insert
    void insertFavorite(Favorite favorite);

    @Delete
    void deleteById(int id);
}
