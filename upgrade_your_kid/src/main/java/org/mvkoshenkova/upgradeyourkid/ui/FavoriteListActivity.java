package org.mvkoshenkova.upgradeyourkid.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.mvkoshenkova.upgradeyourkid.R;
import org.mvkoshenkova.upgradeyourkid.persistence.enums.Category;
import org.mvkoshenkova.upgradeyourkid.ui.BaseActivity;
import org.mvkoshenkova.upgradeyourkid.ui.adapter.FavoriteListAdapter;
import org.mvkoshenkova.upgradeyourkid.ui.adapter.GameListAdapter;
import org.mvkoshenkova.upgradeyourkid.ui.adapter.GameViewModel;

public class FavoriteListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.favorite_game_list);
        //layoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //adapter
        FavoriteListAdapter recyclerViewAdapter = new FavoriteListAdapter(getApplicationContext());
        recyclerView.setAdapter(recyclerViewAdapter);

        //divider
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        //prepare data
        GameViewModel viewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        viewModel.getAllFavoriteGames().observe(FavoriteListActivity.this,
                recyclerViewAdapter::addFavoriteGameItems);

        recyclerViewAdapter.setViewModel(viewModel);


    }

}
