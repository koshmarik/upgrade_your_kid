package org.mvkoshenkova.upgradeyourkid.persistence.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import org.mvkoshenkova.upgradeyourkid.persistence.dao.FavoriteDao;
import org.mvkoshenkova.upgradeyourkid.persistence.dao.GameDao;
import org.mvkoshenkova.upgradeyourkid.persistence.entity.Game;

/**
 * Created by Mariya Koshenkova on 20.03.18.
 */
@Database(entities = {Game.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract GameDao gameDao();
    public abstract FavoriteDao favoriteDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "uyk_database")
                            // allow queries on the main thread.
                            // TODO Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
