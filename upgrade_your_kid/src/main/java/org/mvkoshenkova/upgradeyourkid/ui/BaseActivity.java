package org.mvkoshenkova.upgradeyourkid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
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

    private BasicApp app;
    private GameRepository gameRepository;
    private FavoriteRepository favoriteRepository;
    private AboutUsDialogFragment aboutUsDialogFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        app = (BasicApp) getApplicationContext();
        gameRepository = new GameRepository(app);
        favoriteRepository = new FavoriteRepository(app);
        aboutUsDialogFragment = new AboutUsDialogFragment();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_favorites:
                Intent intent = new Intent(this, FavoriteListActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_add_my:
                return true;
            case R.id.action_about:
                aboutUsDialogFragment.show(getFragmentManager(), "about us");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
