package org.mvkoshenkova.upgradeyourkid.persistence.repository;

import android.app.Application;

import org.mvkoshenkova.upgradeyourkid.BasicApp;
import org.mvkoshenkova.upgradeyourkid.persistence.dao.FavoriteDao;

/**
 * Created by Mariya Koshenkova on 27.03.18.
 */

public class FavoriteRepository {

    private FavoriteDao favoriteDao;

    public FavoriteRepository(Application application) {
        favoriteDao = ((BasicApp)application).getDatabase().favoriteDao();
    }
}
