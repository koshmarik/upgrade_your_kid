package org.mvkoshenkova.upgradeyourkid.persistence.database;

import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import org.mvkoshenkova.upgradeyourkid.AppExecutors;
import org.mvkoshenkova.upgradeyourkid.persistence.dao.FavoriteDao;
import org.mvkoshenkova.upgradeyourkid.persistence.dao.GameDao;
import org.mvkoshenkova.upgradeyourkid.persistence.entity.Favorite;
import org.mvkoshenkova.upgradeyourkid.persistence.entity.Game;
import org.mvkoshenkova.upgradeyourkid.persistence.enums.Category;

/**
 * Created by Mariya Koshenkova on 20.03.18.
 */
@Database(entities = {Game.class, Favorite.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "uyk_database";
    private static AppDatabase INSTANCE;

    public abstract GameDao gameDao();

    public abstract FavoriteDao favoriteDao();

    private final MutableLiveData<Boolean> isDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(Context context, AppExecutors executors) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context.getApplicationContext(), executors);
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(final Context appContext,
                                             final AppExecutors executors) {
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            // get data for pre-population
                            AppDatabase database = AppDatabase.getInstance(appContext, executors);
                            insertData(database);
                            // notify that the database was created and it's ready to be used
                            database.setDatabaseCreated();
                        });
                    }
                })
                .allowMainThreadQueries() //TODO fix it
                .build();
    }

    private static void insertData(AppDatabase database) {
        database.runInTransaction(() -> {
            database.gameDao().insertGame(new Game(1, Category.FROM_0_TO_3_MONTH.id, "От 0 до 3 - 1", "Описание 1", "Коммент 1"));
            database.gameDao().insertGame(new Game(2, Category.FROM_0_TO_3_MONTH.id, "От 0 до 3 - 2", "Описание 2", "Коммент 2"));
            database.gameDao().insertGame(new Game(3, Category.FROM_0_TO_3_MONTH.id, "От 0 до 3 - 3", "Описание 3", "Коммент 3"));
            database.gameDao().insertGame(new Game(4, Category.FROM_0_TO_3_MONTH.id, "От 0 до 3 - 4", "Описание 4", "Коммент 4"));
            database.gameDao().insertGame(new Game(5, Category.FROM_6_TO_9_MONTH.id, "От 3 до 6 - 1", "Описание 5", "Коммент 5"));
        });
    }

    private void setDatabaseCreated() {
        isDatabaseCreated.postValue(true);
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
