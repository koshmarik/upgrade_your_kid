package org.mvkoshenkova.upgradeyourkid.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.mvkoshenkova.upgradeyourkid.R;

/**
 * Created by Mariya Koshenkova on 24.03.18.
 */

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.GameListHolder> {

    public class GameListHolder extends ViewHolder{
        TextView gameTitle;
        ImageButton favorites;

        public GameListHolder(View itemView) {
            super(itemView);
            gameTitle = itemView.findViewById(R.id.game_title);
            favorites = itemView.findViewById(R.id.favorites);
        }
    }

    @Override
    public GameListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(GameListHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
