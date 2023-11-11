package it.cudia.studio.android.pokedroid.fragment;

import static androidx.core.app.ActivityCompat.invalidateOptionsMenu;
import static com.google.android.material.color.utilities.MaterialDynamicColors.error;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

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
import it.cudia.studio.android.pokedroid.model.AppDatabase;
import it.cudia.studio.android.pokedroid.model.Pokemon;
import it.cudia.studio.android.pokedroid.request.BooleanRequest;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;
import it.cudia.studio.android.pokedroid.singleton.SingletonVolley;
import it.cudia.studio.android.pokedroid.utility.Utility;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaPokemonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPokemonFragment extends Fragment {

    private static final String TAG = "ListaPokemonFragment";

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
        invalidateOptionsMenu(getActivity());

        RequestQueue queue = SingletonVolley.getInstance(getActivity().getApplicationContext()).
                getRequestQueue();

    }

    @Override
    public void onResume() {
        super.onResume();
        PokedroidToolbar.disableBackNavigation();
        //new Thread(new SaveAvanzamentoPokedexDBlocal()).start();
    }



    public class SaveAvanzamentoPokedexDBlocal implements  Runnable{

        public SaveAvanzamentoPokedexDBlocal(){}
        @Override
        public void run() {
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());

            int idPokedex = db.userDao().loadUserPokedex(1);
            Log.d(TAG, "onResponse() called with: response idPokedex = [" + idPokedex + "]");
            if(idPokedex!=0){
                String urlGet = getResources().getString(R.string.base_url) + "PokedexServlet?pokedex="+db.userDao().loadUserPokedex(1);
                JsonObjectRequest jsonObjectRequestGet = null;
                jsonObjectRequestGet = new JsonObjectRequest
                        (Request.Method.GET, urlGet, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    db.userDao().UpdateAvanzamentoPokedex(response.getInt("avanzamento"));
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error
                                Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                            }
                        });
                if(jsonObjectRequestGet!=null)
                    SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequestGet);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_lista_pokemon, container, false);

       PokedroidToolbar.disableBackNavigation();
       FloatingActionButton addPokemon = view.findViewById(R.id.addPokemon);
       LinearLayout lyUserInfoStat = view.findViewById(R.id.lyUserInfoStat);
       lyUserInfoStat.getBackground().setTint(getActivity().getBaseContext().getResources().getColor(R.color.color_card));
        addPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ListaPokemonFragment.this).navigate(R.id.action_listaPokemonFragment_to_riscattaPokemonFragment);
            }
        });
        /*ListaPokemonFragment home = new ListaPokemonFragment();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fgListaPokemon, home).commit();*/
        // data to populate the RecyclerView with

        Thread t = new Thread(new RetrivePasswordAndEmailLocalDBRunnable(view.findViewById(R.id.recyclerViewListaPokemon)));
        t.start();

        Thread t_setUserData = new Thread(new RetriveDataUserLocalDBRunnable(view.findViewById(R.id.tvUsernameUserLista),
                view.findViewById(R.id.tvPercentualeAvanzamentoPokedex),
                view.findViewById(R.id.pbAvanzamento)));
        t_setUserData.start();

        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        // Inflate the layout for this fragment

        return view;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu,menuInflater);

        menu.findItem(R.id.menu_profile).setVisible(true);

        menu.findItem(R.id.menu_profile).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                NavHostFragment.findNavController(ListaPokemonFragment.this).navigate(R.id.action_listaPokemonFragment_to_profileFragment);
                return true;
            }
        });
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {

        menu.findItem(R.id.menu_profile).setVisible(true);
    }

    public class RetrivePasswordAndEmailLocalDBRunnable implements Runnable {

        RecyclerView recyclerView;
        RetrivePasswordAndEmailLocalDBRunnable(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        public void run() {
            Vector<Pokemon> data = new Vector<Pokemon>();

            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());

            if(db.userDao().loadUserUsername(1)!=null){
                String url = getResources().getString(R.string.base_url)+"PokemonServlet?email="+db.userDao().loadUserEmail(1)+"&"+"password="+db.userDao().loadUserPassword(1);

                int numberOfColumns = 2;
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),numberOfColumns, GridLayoutManager.VERTICAL, false));


                JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET,url, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                                for(int i=0; i<=150; i++){

                                    data.add(new Pokemon(i+1));
                                }

                                int j = 0;

                                while(j < response.length()){
                                    JSONObject jsonObject = (JSONObject) response.opt(j);
                                    try {
                                        data.remove((int)jsonObject.getLong("idPokemon")-1);
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
                                Log.d(TAG, data.toString());
                                PokeCardRecyclerViewAdapter adapter = new PokeCardRecyclerViewAdapter(getContext(),data);

                                recyclerView.setAdapter(adapter);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                    }
                });

                SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);
                Log.d(TAG, "run() called");
            }
        }
    }

    public class RetriveDataUserLocalDBRunnable implements Runnable {

        TextView username;
        TextView avanzamentoPokedex;
        ProgressBar pbAvanzamento;
        RetriveDataUserLocalDBRunnable(TextView username, TextView avanzamentoPokedex, ProgressBar pbAvantamento) {
            this.username = username;
            this.avanzamentoPokedex = avanzamentoPokedex;
            this.pbAvanzamento = pbAvantamento;
        }
        public void run() {
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());

            if(db.userDao().loadUserUsername(1)!=null){
                this.username.setText(db.userDao().loadUserUsername(1));
            }


            if(db.userDao().loadAvanzamentoPokedex(1)!=null){
                int progress = db.userDao().loadAvanzamentoPokedex(1).intValue();

                getActivity().runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        avanzamentoPokedex.setText( Utility.calcolaPercentuale(Double.valueOf(progress),Double.valueOf(151) ) + "%");
                        pbAvanzamento.setMax(100);
                        pbAvanzamento.setMin(0);
                        pbAvanzamento.setProgress((int) Utility.calcolaPercentuale(Double.valueOf(progress),Double.valueOf(151) ));

                    }
                });

            }


        }
    }

}