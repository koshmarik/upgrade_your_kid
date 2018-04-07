package org.mvkoshenkova.upgradeyourkid.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.mvkoshenkova.upgradeyourkid.R;
import org.mvkoshenkova.upgradeyourkid.persistence.entity.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mariya Koshenkova on 24.03.18.
 */

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameListViewHolder> {

    private List<Game> gameList;

    public GameListAdapter() {
        this.gameList = new ArrayList<>();
    }

    @Override
    public GameListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GameListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.game_item, parent, false));
    }

    @Override
    public void onBindViewHolder(GameListViewHolder holder, int position) {
        Game borrowModel = gameList.get(position);
        holder.gameTitle.setText(borrowModel.getName());
        holder.itemView.setTag(borrowModel);
    }

    public void addItems(List<Game> games){
        this.gameList.addAll(games);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }


    public class GameListViewHolder extends ViewHolder {
        TextView gameTitle;
        ImageButton favorites;

        public GameListViewHolder(View itemView) {
            super(itemView);
            gameTitle = itemView.findViewById(R.id.game_title);
            favorites = itemView.findViewById(R.id.favorites);
        }
    }

}
