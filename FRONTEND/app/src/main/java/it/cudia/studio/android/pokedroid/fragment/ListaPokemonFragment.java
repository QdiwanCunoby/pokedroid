package it.cudia.studio.android.pokedroid.fragment;

import static com.google.android.material.color.utilities.MaterialDynamicColors.error;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.adapter.PokeCardRecyclerViewAdapter;
import it.cudia.studio.android.pokedroid.model.Pokemon;
import it.cudia.studio.android.pokedroid.request.BooleanRequest;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;
import it.cudia.studio.android.pokedroid.singleton.SingletonVolley;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaPokemonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPokemonFragment extends Fragment {

    private static final String TAG = "ListaPokemonFragment";

    private RecyclerView pokeCard;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaPokemonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPokemonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPokemonFragment newInstance(String param1, String param2) {
        ListaPokemonFragment fragment = new ListaPokemonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        setHasOptionsMenu(true);
        RequestQueue queue = SingletonVolley.getInstance(getActivity().getApplicationContext()).
                getRequestQueue();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_lista_pokemon, container, false);

       FloatingActionButton addPokemon = view.findViewById(R.id.addPokemon);

        addPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ListaPokemonFragment.this).navigate(R.id.action_listaPokemonFragment_to_riscattaPokemonFragment);
            }
        });

        // data to populate the RecyclerView with
        Vector<Pokemon> data = new Vector<Pokemon>();
        String url = getResources().getString(R.string.base_url)+"PokemonServlet?email=test@gmail.com&password=password";

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewListaPokemon);
        int numberOfColumns = 2;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),numberOfColumns, GridLayoutManager.VERTICAL, false));


            JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET,url, null,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {



                            for(int i=0; i<=150; i++){

                                Log.d(TAG, new Pokemon(i+1).toString());
                                data.add(new Pokemon(i+1));
                            }

                            int j = 0;

                            while(j < response.length()){
                                JSONObject jsonObject = (JSONObject) response.opt(j);
                                try {
                                    data.add((int)jsonObject.getLong("idPokemon")-1,new Pokemon(
                                            jsonObject.getLong("idPokemon"),
                                            jsonObject.getString("nome"),
                                            jsonObject.getInt("tipo"),
                                            jsonObject.getInt("forza"),
                                            jsonObject.getInt("grinta"),
                                            jsonObject.getInt("fortuna"),
                                            jsonObject.getInt("difesa"),
                                            jsonObject.getInt("astuzia"),
                                            jsonObject.getInt("resistenza"),
                                            jsonObject.getInt("velocita")));
                                } catch (JSONException ex) {
                                    throw new RuntimeException(ex);
                                }
                                j++;
                            }

                            PokeCardRecyclerViewAdapter adapter = new PokeCardRecyclerViewAdapter(getContext(),data);
                            try {
                                Log.d(TAG, "onResponse() called with: response = [" + response + "]" + " "+response.get(0));
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            recyclerView.setAdapter(adapter);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                }
            });

            SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);



        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        // Inflate the layout for this fragment

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu,menuInflater);

        menu.findItem(R.id.menu_profile).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                NavHostFragment.findNavController(ListaPokemonFragment.this).navigate(R.id.action_listaPokemonFragment_to_profileFragment);
                return true;
            }
        });
    }




}