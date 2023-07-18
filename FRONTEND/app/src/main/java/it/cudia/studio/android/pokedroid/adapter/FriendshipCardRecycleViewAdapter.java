package it.cudia.studio.android.pokedroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import it.cudia.studio.android.pokedroid.R;

public class FriendshipCardRecycleViewAdapter extends RecyclerView.Adapter<FriendshipCardRecycleViewAdapter.ViewHolder>{

    private String[] mData;

    private LayoutInflater mInflater;

    public FriendshipCardRecycleViewAdapter(Context context, String[] data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public FriendshipCardRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  mInflater.inflate(R.layout.card_friend, parent, false);;
        return new FriendshipCardRecycleViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendshipCardRecycleViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        ProgressBar friendProgressBar;
        TextView friendUsername;
        TextView labelScore;
        TextView scoreFriendPokedexScore;

        ViewHolder(View itemView ){
            super(itemView);

            this.friendProgressBar = itemView.findViewById(R.id.pokedexFriendProgressbar);
            this.friendUsername = itemView.findViewById(R.id.friendUsername);
            this.labelScore = itemView.findViewById(R.id.labelPokedexScore);
            this.scoreFriendPokedexScore = itemView.findViewById(R.id.pokedexScore);

        }
    }
}
