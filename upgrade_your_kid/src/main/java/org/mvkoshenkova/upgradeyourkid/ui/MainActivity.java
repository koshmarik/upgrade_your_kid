package org.mvkoshenkova.upgradeyourkid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.mvkoshenkova.upgradeyourkid.R;
import org.mvkoshenkova.upgradeyourkid.persistence.database.AppDatabase;

public class MainActivity extends BaseActivity {

    public static final String TAG_NAME = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
