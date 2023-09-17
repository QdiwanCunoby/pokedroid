package it.cudia.studio.android.pokedroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.fragment.ListaPokemonFragment;
import it.cudia.studio.android.pokedroid.model.Pokemon;

public class PokeCardRecyclerViewAdapter extends RecyclerView.Adapter<PokeCardRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "PokeCardRecyclerViewAda";

    private Vector<Pokemon> mData;

    private LayoutInflater mInflater;
    private Context context;

    public PokeCardRecyclerViewAdapter(Context context, Vector<Pokemon> data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.context = context;
    }


    @NonNull
    @Override
    public PokeCardRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.card_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokeCardRecyclerViewAdapter.ViewHolder holder, int position) {

        holder.cardTextView.setText("n."+mData.get(position).getIdPokemon());

        if(mData.get(position).getNome()!=null){
            holder.card.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Log.d(TAG, mData.get(holder.getAdapterPosition()).toString());
                    Bundle result = new Bundle();
                    result.putInt("forza", mData.get(holder.getAdapterPosition()).getForza());
                    result.putInt("velocita", mData.get(holder.getAdapterPosition()).getVelocita());
                    result.putInt("grinta", mData.get(holder.getAdapterPosition()).getGrinta());
                    result.putInt("difesa", mData.get(holder.getAdapterPosition()).getDifesa());
                    result.putInt("fortuna", mData.get(holder.getAdapterPosition()).getFortuna());
                    result.putInt("astuzia", mData.get(holder.getAdapterPosition()).getAstuzia());
                    result.putInt("resistenza", mData.get(holder.getAdapterPosition()).getResistenza());
                    result.putInt("tipo", mData.get(holder.getAdapterPosition()).getTipo());
                    result.putString("pokemonImage", mData.get(holder.getAdapterPosition()).getNome().toLowerCase());
                    Log.d(TAG, result.toString());

                    FragmentManager manager = ((AppCompatActivity)context).getSupportFragmentManager();
                    //  NavHostFragment.findNavController(manager.findFragmentById(R.id.fgListaPokemon)).navigate(R.id.action_listaPokemonFragment_to_pokemonStatisticsFragment);
                    manager.setFragmentResult("requestKey", result);
                    Navigation.findNavController(v).navigate(R.id.action_listaPokemonFragment_to_pokemonStatisticsFragment);
                }
            });

            switch (mData.get(holder.getAdapterPosition()).getTipo()){
                case 0:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.questionmark));
                    break;
                case 1:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_normale));
                    break;
                case 2:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_lotta));
                    break;
                case 3:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_volante));
                    break;
                case 4:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_veleno));
                    break;
                case 5:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_terra));
                    break;
                case 6:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_roccia));
                    break;
                case 7:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_coleottero));
                    break;
                case 8:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_spettro));
                    break;
                case 9:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_fuoco));
                    break;
                case 10:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_acqua));
                    break;
                case 11:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_erba));
                    break;
                case 12:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_elettro));
                    break;
                case 13:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_spico));
                    break;
                case 14:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_chiaccio));
                    break;
                case 15:
                    holder.card.setCardBackgroundColor(this.mInflater.getContext().getResources().getColor(R.color.type_drago));
                    break;
            }
            String uri = "@drawable/"+mData.get(holder.getAdapterPosition()).getNome().toLowerCase();
            Log.d(TAG, "onBindViewHolder() called with:"+uri);
            int imageResource =  holder.itemView.getResources().getIdentifier(uri, "drawable",  holder.itemView.getContext().getPackageName());
            Log.d(TAG, "onBindViewHolder() called with:"+imageResource);
            holder.cardImage.setImageResource(imageResource);
        }
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        ImageView cardImage;
        TextView cardTextView;
        CardView card;

        ViewHolder(View itemView ){
            super(itemView);
            cardImage = itemView.findViewById(R.id.pokeImage);
            cardTextView = itemView.findViewById(R.id.pokeNumber);
            card = itemView.findViewById(R.id.PokeCard);


        }
    }
}
