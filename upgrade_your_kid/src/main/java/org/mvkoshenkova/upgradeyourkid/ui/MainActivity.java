package org.mvkoshenkova.upgradeyourkid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import org.mvkoshenkova.upgradeyourkid.R;
import org.mvkoshenkova.upgradeyourkid.persistence.database.AppDatabase;

public class MainActivity extends BaseActivity {

    public static final String TAG_NAME = "MainActivity";

    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);


        FloatingActionButton fab = findViewById(R.id.add_game);
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        int count = gameRepository.gamesCount();
        Log.d(TAG_NAME, "games count: " + count);
    }

    public void openGames(View view) {
        Intent intent = new Intent(this, GameListActivity.class);
        String categoryTag = view.getTag().toString();
        Log.d(TAG_NAME, "click open games: " + categoryTag);
        intent.putExtra("CATEGORY", categoryTag);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
