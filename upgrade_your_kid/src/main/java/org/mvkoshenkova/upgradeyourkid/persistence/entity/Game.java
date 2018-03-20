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
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "category")
    public Integer category;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "content")
    public String content;
}
