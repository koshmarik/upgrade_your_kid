package org.mvkoshenkova.upgradeyourkid.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import org.mvkoshenkova.upgradeyourkid.R;
import org.mvkoshenkova.upgradeyourkid.persistence.enums.Category;
import org.mvkoshenkova.upgradeyourkid.ui.adapter.GameListAdapter;
import org.mvkoshenkova.upgradeyourkid.ui.adapter.GameViewModel;

/**
 * Created by Mariya Koshenkova on 25.03.18.
 */

public class GameListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        //category description
        TextView categoryDesc = findViewById(R.id.category_description);
        categoryDesc.setText(category.description);

        //prepare data
        GameViewModel viewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        viewModel.getFavorites().observe(GameListActivity.this,
                recyclerViewAdapter::addFavoritesItems);
        viewModel.getGamesByCategory(category).observe(GameListActivity.this,
                recyclerViewAdapter::addItems);

        recyclerViewAdapter.setViewModel(viewModel);

    }
}
