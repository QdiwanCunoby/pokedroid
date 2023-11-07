package it.cudia.studio.android.pokedroid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

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
import it.cudia.studio.android.pokedroid.adapter.FriendshipCardRecycleViewAdapter;
import it.cudia.studio.android.pokedroid.model.AppDatabase;
import it.cudia.studio.android.pokedroid.model.Friend;
import it.cudia.studio.android.pokedroid.model.Pokemon;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;
import it.cudia.studio.android.pokedroid.singleton.SingletonVolley;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FriendsListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FriendsListFragment extends Fragment {

    private static final String TAG = "FriendsListFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FriendsListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment friendsListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FriendsListFragment newInstance(String param1, String param2) {
        FriendsListFragment fragment = new FriendsListFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends_list, container, false);

        FloatingActionButton addFriend = view.findViewById(R.id.addFriend);

        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FriendsListFragment.this).navigate(R.id.action_friendsListFragment_to_sendFrindshipRequestFragment);
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewListaFriend);
        Thread t = new Thread(new GetListFriend(recyclerView));
        t.start();
        //FriendshipCardRecycleViewAdapter adapter = new FriendshipCardRecycleViewAdapter(getContext(),data);
        //recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu,menuInflater);

        PokedroidToolbar.disableProfileIcon();
        PokedroidToolbar.enableBackNavigation();

        menu.findItem(R.id.menu_profile).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                NavHostFragment.findNavController(FriendsListFragment.this).navigate(R.id.action_sendFrindshipRequestFragment_to_profileFragment);
                return true;
            }
        });
    }


    public class GetListFriend implements Runnable{
        RecyclerView recyclerView;
        GetListFriend(RecyclerView recyclerView){
            this.recyclerView = recyclerView;
        }
        public void run() {
            Vector<Friend> data = new Vector<Friend>();
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());

            if(db.userDao().loadUserEmail(1)!=null){
                String url = getResources().getString(R.string.base_url)+"AmiciziaServlet?username="+db.userDao().loadUserUsername(1);

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                JSONArray jsonArrayObject = null;
                                try {
                                    jsonArrayObject = (JSONArray) response.getJSONArray("infoFriendList");
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                                int i = 0;

                                while(i < response.length()){

                                    JSONObject jsonObject = (JSONObject) jsonArrayObject.opt(i);

                                    try {
                                        data.add(new Friend(jsonObject.getString("username"),calcolaPercentuale(jsonObject.getDouble("completamentoPokedex"),151)));
                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }

                                    i++;
                                }
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                                FriendshipCardRecycleViewAdapter adapter = new FriendshipCardRecycleViewAdapter(getContext(),data);
                                recyclerView.setAdapter(adapter);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });

                SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);
            }
        }

        public double calcolaPercentuale(double numero, double totale) {
            if (totale == 0) {
                throw new IllegalArgumentException("Il totale non può essere zero.");
            }

            double percentuale = (numero / totale) * 100;
            return percentuale;
        }
    }
}



