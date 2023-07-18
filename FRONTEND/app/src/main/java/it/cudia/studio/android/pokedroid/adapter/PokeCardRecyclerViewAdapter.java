package it.cudia.studio.android.pokedroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import it.cudia.studio.android.pokedroid.R;

public class PokeCardRecyclerViewAdapter extends RecyclerView.Adapter<PokeCardRecyclerViewAdapter.ViewHolder> {


    private String[] mData;

    private LayoutInflater mInflater;

    public PokeCardRecyclerViewAdapter(Context context, String[] data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }


    @NonNull
    @Override
    public PokeCardRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokeCardRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.cardTextView.setText("n."+mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        ImageView cardImage;
        TextView cardTextView;

        ViewHolder(View itemView ){
            super(itemView);
            cardImage = itemView.findViewById(R.id.pokeImage);
            cardTextView = itemView.findViewById(R.id.pokeNumber);

        }
    }
}
