package org.mvkoshenkova.upgradeyourkid.persistence.entity;

import android.arch.persistence.room.ColumnInfo;

/**
 * Created by Mariya Koshenkova on 30.04.18.
 */

public class FavoriteGame {
    @ColumnInfo(name = "gameId")
    private Integer gameId;
    @ColumnInfo(name = "favoriteId")
    private Integer favoriteId;
    @ColumnInfo(name = "category")
    private Integer category;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "content")
    private String content;
    @ColumnInfo(name = "comment")
    private String comment;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
