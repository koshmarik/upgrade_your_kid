package org.mvkoshenkova.upgradeyourkid;

import android.app.Application;

import org.mvkoshenkova.upgradeyourkid.persistence.database.AppDatabase;

/**
 * Created by Mariya Koshenkova on 24.03.18.
 */

public class BasicApp extends Application {

    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
        getDatabase();//init
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }

}
