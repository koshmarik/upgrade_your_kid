package org.mvkoshenkova.upgradeyourkid.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
    private Animation showGame;

    public GameListAdapter(Context context) {
        this.gameList = new ArrayList<>();
        showGame = AnimationUtils.loadAnimation(context, R.anim.show_game);
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
        holder.itemView.setOnClickListener(view -> {
            if (holder.gameFullDetails.getVisibility() == View.GONE) {
                Game game = gameList.get(position);
                holder.gameDescription.setText(Html.fromHtml("<b>Описание: </b>" + game.getContent()));
                holder.gameComment.setText(Html.fromHtml("<b>Коментарий: </b>" + game.getComment()));
                holder.gameFullDetails.setVisibility(View.VISIBLE);
                holder.gameFullDetails.startAnimation(showGame);
            } else {
                holder.gameFullDetails.setVisibility(View.GONE);
            }
        });
    }

    public void addItems(List<Game> games) {
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
        LinearLayout gameFullDetails;
        TextView gameDescription;
        TextView gameComment;

        public GameListViewHolder(View itemView) {
            super(itemView);
            gameTitle = itemView.findViewById(R.id.game_title);
            favorites = itemView.findViewById(R.id.favorites);
            gameFullDetails = itemView.findViewById(R.id.game_element_content);
            gameDescription = itemView.findViewById(R.id.game_content);
            gameComment = itemView.findViewById(R.id.game_comment);
        }

    }

}
