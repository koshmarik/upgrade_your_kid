package org.mvkoshenkova.upgradeyourkid.persistence.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.mvkoshenkova.upgradeyourkid.persistence.enums.Category;

/**
 * Created by Mariya Koshenkova on 20.03.18.
 */
@Entity
public class Game {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "category")
    private Integer category;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "content")
    private String content;
    @ColumnInfo(name = "comment")
    private String comment;

    public Game() {
    }

    public Game(int id, Integer category, String name, String content, String comment) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.content = content;
        this.comment = comment;
    }

    public Game(Integer category, String name, String content, String comment) {
        this.category = category;
        this.name = name;
        this.content = content;
        this.comment = comment;
    }

    public Game(Category category, String name, String content, String comment) {
        this.category = category.id;
        this.name = name;
        this.content = content;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
