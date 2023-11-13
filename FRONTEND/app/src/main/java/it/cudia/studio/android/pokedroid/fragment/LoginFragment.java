package it.cudia.studio.android.pokedroid.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.fragment.dialog.CustomDialog;
import it.cudia.studio.android.pokedroid.model.AppDatabase;
import it.cudia.studio.android.pokedroid.model.entity.User;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;
import it.cudia.studio.android.pokedroid.singleton.SingletonVolley;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    private static final String TAG = "LoginFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Switch saveLogin;
    boolean saveDataLogin = false;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        /*Set activated OptionMenu in a tool bar*/
        setHasOptionsMenu(true);

        // Get instance of a RequestQueue from a Singleton
        RequestQueue queue = SingletonVolley.getInstance(getActivity().getApplicationContext()).
                getRequestQueue();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        TextView tvRegistrati = v.findViewById(R.id.tvRegistrati);
        tvRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_registrationFragment);
            }
        });

        EditText email = v.findViewById(R.id.etNewPassword);
        EditText password = v.findViewById(R.id.etCurrentPassword);
        Button btAccedi = v.findViewById(R.id.btSendChangePasswordRequest);
        CustomDialog dialog = new CustomDialog();
        saveLogin = (Switch) v.findViewById(R.id.swMantieniAccessoLog);
        saveLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged() called with: buttonView = [" + buttonView + "], isChecked = [" + isChecked + "]");
                if(isChecked){
                    saveDataLogin = true;
                }else{
                    saveDataLogin = false;
                }
            }
        });

        btAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                if(email.getText().toString().equals("") || password.getText().toString().equals("")){
                    Log.d(TAG, "email "+email.getText().toString()+" password "+password.getText().toString());
                    dialog.setDialogWrong("Nessun campo deve essere lasciato vuoto");
                    dialog.show(getFragmentManager(),"CustomDialog");
                    return;
                }
                //NavHostFragment.findNavController(RegistrationFragment.this).navigate(R.id.action_registrationFragment_to_listaPokemonFragment);
                String url = getResources().getString(R.string.base_url)+"UtenteServlet?email="+email.getText().toString()+"&password="+password.getText().toString()+"";
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d(TAG, "onResponse() called with: response = [" + response + "]");
                                if(response != null){// if response is OK attivate dialog to comunicate user the right bheaviour
                                   dialog.setDialogRight("Account reggistrato correttamente");
                                   dialog.show(getFragmentManager(),"CustomDialog");
                               }

                                /*IN THIS IF AND ELSE CODE BLOCK, THERE IS A CHECK ABOUT THE USER ACTIVATION
                                    OF THE OPTION TO REMAIN AUTHENTICATE WHEN CLOSE APP AND RESTART IN A SECOND MOMENT*/
                                if(saveDataLogin){
                                    Thread t = null;
                                    try {
                                        t = new Thread(new LoginFragment.SaveUserDataLocalDBRunnable(new User(1,
                                                response.getJSONObject("user").getString("username"),
                                                response.getJSONObject("utente").getString("email"),
                                                response.getJSONObject("utente").getString("password"),
                                                response.getJSONObject("pokedex").getInt("idPokedex"),
                                                response.getJSONObject("user").getString("codiceAmico"),
                                                (float) response.getJSONObject("pokedex").getDouble("completamento"),
                                                response.getJSONObject("user").getBoolean("genere"),
                                                true)));
                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }
                                    t.start();
                                }else {
                                    Thread t = null;
                                    try {

                                        t = new Thread(new LoginFragment.SaveUserDataLocalDBRunnable(new User(1,
                                                response.getJSONObject("user").getString("username"),
                                                response.getJSONObject("utente").getString("email"),
                                                response.getJSONObject("utente").getString("password"),
                                                response.getJSONObject("pokedex").getInt("idPokedex"),
                                                response.getJSONObject("user").getString("codiceAmico"),
                                                (float) response.getJSONObject("pokedex").getDouble("completamento"),
                                                response.getJSONObject("user").getBoolean("genere"),
                                                false)));

                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }
                                    t.start();
                                }
                            }
                        }
                                , new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error
                                dialog.setDialogWrong("Credenziali errate!");
                                dialog.show(getFragmentManager(),"CustomDialog");
                                Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                            }
                        });
                // send request with a instance of singleton VOLLEY network android tool
                SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);

            }

        });

        return v;
    }

    public class SaveUserDataLocalDBRunnable implements Runnable {

        private User user;

        public SaveUserDataLocalDBRunnable(User user) {
            this.user = user;
        }

        public void run() {
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());
            db.userDao().getAll();
            /*if there isn't a user with id 1 ( this is correct because the logic of application take only one user in local db,
            if there is yet one user there isn't necessity to save another because the user is yey logged and the record is deleted
            only when that do the logout*/
            if(db.userDao().loadUserUsername(1)==null) {
                db.userDao().insert(new User(1, user.getUsername(), user.getEmail(), user.getPassword(), user.getPokedex(), user.getCodiceAmico(),
                        user.getPokedexCompletamento(), user.isGenere(), user.isAccesso()));
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu,menuInflater);
        Log.d(TAG, "onCreateOptionsMenu() called with: menu = [" + menu + "], menuInflater = [" + menuInflater + "]");
        PokedroidToolbar.disableProfileIcon();
    }
}