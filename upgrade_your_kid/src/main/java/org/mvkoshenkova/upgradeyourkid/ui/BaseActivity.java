package org.mvkoshenkova.upgradeyourkid.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.mvkoshenkova.upgradeyourkid.BasicApp;
import org.mvkoshenkova.upgradeyourkid.R;
import org.mvkoshenkova.upgradeyourkid.persistence.repository.FavoriteRepository;
import org.mvkoshenkova.upgradeyourkid.persistence.repository.GameRepository;

/**
 * Created by Mariya Koshenkova on 25.03.18.
 */

public class BaseActivity extends AppCompatActivity {

    BasicApp app;
    GameRepository gameRepository;
    FavoriteRepository favoriteRepository;

    protected final void onCreate(@Nullable Bundle savedInstanceState, int layoutId) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);

        app = (BasicApp) getApplicationContext();
        gameRepository = new GameRepository(app);
        favoriteRepository = new FavoriteRepository(app);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_favorites) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
