package org.mvkoshenkova.upgradeyourkid.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Mariya Koshenkova on 20.03.18.
 */
@Entity
public class Favorite {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "game_id")
    private int gameId;

    public Favorite() {
    }

    public Favorite(int gameId) {
        this.gameId = gameId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
