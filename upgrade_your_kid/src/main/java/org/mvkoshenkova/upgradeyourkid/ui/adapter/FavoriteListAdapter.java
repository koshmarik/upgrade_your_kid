package org.mvkoshenkova.upgradeyourkid.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
import org.mvkoshenkova.upgradeyourkid.persistence.entity.FavoriteGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mariya Koshenkova on 30.04.18.
 */

public class FavoriteListAdapter extends RecyclerView.Adapter<FavoriteListAdapter.FavoriteListViewHolder> {

    private List<FavoriteGame> favoriteGames;
    private GameViewModel viewModel;
    private Context context;
    private Animation showGame;

    public FavoriteListAdapter(Context context) {
        this.context = context;
        this.favoriteGames = new ArrayList<>();
        showGame = AnimationUtils.loadAnimation(context, R.anim.show_game);
    }

    @Override
    public FavoriteListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FavoriteListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favorite_game_item, parent, false));
    }

    @Override
    public void onBindViewHolder(FavoriteListViewHolder holder, int position) {
        FavoriteGame gameModel = favoriteGames.get(position);
        holder.gameTitle.setText(gameModel.getName());
        holder.itemView.setTag(gameModel);
        holder.itemView.setOnClickListener(view -> {
            if (holder.gameFullDetails.getVisibility() == View.GONE) {
                FavoriteGame game = favoriteGames.get(position);
                holder.gameDescription.setText(Html.fromHtml("<b>Описание: </b>" + game.getContent()));
                holder.gameComment.setText(Html.fromHtml("<b>Коментарий: </b>" + game.getComment()));
                holder.gameFullDetails.setVisibility(View.VISIBLE);
                holder.gameFullDetails.startAnimation(showGame);
            } else {
                holder.gameFullDetails.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favoriteGames.size();
    }

    public void addFavoriteGameItems(List<FavoriteGame> favoriteGames) {
        this.favoriteGames.addAll(favoriteGames);
        notifyDataSetChanged();
    }

    public void setViewModel(GameViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public class FavoriteListViewHolder extends RecyclerView.ViewHolder {
        TextView gameTitle;
        ImageButton favorites;
        LinearLayout gameFullDetails;
        TextView gameDescription;
        TextView gameComment;

        public FavoriteListViewHolder(View itemView) {
            super(itemView);
            gameTitle = itemView.findViewById(R.id.game_title);
            favorites = itemView.findViewById(R.id.favorites);
            gameFullDetails = itemView.findViewById(R.id.game_element_content);
            gameDescription = itemView.findViewById(R.id.game_content);
            gameComment = itemView.findViewById(R.id.game_comment);
        }
    }
}
