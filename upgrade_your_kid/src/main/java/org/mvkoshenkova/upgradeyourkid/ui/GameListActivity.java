package org.mvkoshenkova.upgradeyourkid.ui;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.mvkoshenkova.upgradeyourkid.R;
import org.mvkoshenkova.upgradeyourkid.persistence.enums.Category;
import org.mvkoshenkova.upgradeyourkid.ui.adapter.GameListAdapter;
import org.mvkoshenkova.upgradeyourkid.ui.adapter.GameViewModel;

/**
 * Created by Mariya Koshenkova on 25.03.18.
 */

public class GameListActivity extends BaseActivity {


    @SuppressLint("MissingSuperCall")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.games_list_main);

        RecyclerView recyclerView = findViewById(R.id.games_list);
        //layoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //adapter
        GameListAdapter recyclerViewAdapter = new GameListAdapter(getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);

        //divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        //load list of games by category
        String categoryTag = getIntent().getStringExtra("CATEGORY");
        Log.d("GameListActivity", "open for " + categoryTag);
        Category category = Category.valueOf(categoryTag);

        GameViewModel viewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        viewModel.getGamesByCategory(category).observe(GameListActivity.this,
                recyclerViewAdapter::addItems);

    }
}
