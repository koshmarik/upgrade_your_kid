package org.mvkoshenkova.upgradeyourkid.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.mvkoshenkova.upgradeyourkid.BasicApp;
import org.mvkoshenkova.upgradeyourkid.R;
import org.mvkoshenkova.upgradeyourkid.persistence.database.AppDatabase;
import org.mvkoshenkova.upgradeyourkid.persistence.entity.Game;
import org.mvkoshenkova.upgradeyourkid.persistence.enums.Category;

import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.add_game);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    public void openGames(View view){
        String categoryTag = view.getTag().toString();
        Category category = Category.valueOf(categoryTag);
        switch (category){
            case FROM_0_TO_3_MONTH:
                BasicApp app = (BasicApp) getApplicationContext();
                List<Game> games = app.getDatabase().gameDao().findAllByCategory(category.id);
                int i = games.size();
                break;
            case FROM_3_TO_6_MONTH:
                break;
            case FROM_6_TO_9_MONTH:
                break;
            case FROM_9_TO_12_MONTH:
                break;
            case FROM_1_TO_2_YEAR:
                break;
            case FROM_2_TO_3_YEAR:
                break;
        }
    }


    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
