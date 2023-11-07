package it.cudia.studio.android.pokedroid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
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
import it.cudia.studio.android.pokedroid.singleton.SingletonVolley;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationFragment extends Fragment {

    private static final String TAG = "RegistrationFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText email;
    EditText confermaEmail;
    EditText password;
    EditText confermaPassword;
    EditText username;
    RadioGroup genere;
    Switch saveRegistration;
    boolean saveDataRegistation = false;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment registrationFragment.
     */
    // TODO: Rename and change types and number of parameters
    @NonNull
    public static RegistrationFragment newInstance(String param1, String param2) {
        RegistrationFragment fragment = new RegistrationFragment();
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
        View v = inflater.inflate(R.layout.fragment_registration, container, false);

         email = v.findViewById(R.id.etEmail);
         confermaEmail = v.findViewById(R.id.etConfermaEmail);
         password = v.findViewById(R.id.etCodiceAmico);
         confermaPassword = v.findViewById(R.id.etConfermaPassword);
         username =  v.findViewById(R.id.etUsername);
         genere = v.findViewById(R.id.genere);
         saveRegistration = (Switch) v.findViewById(R.id.swMantieniAccessoReg);

         Thread t = new Thread(new CeckLocalDBRunnable());

        saveRegistration.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "onCheckedChanged() called with: buttonView = [" + buttonView + "], isChecked = [" + isChecked + "]");
                if(isChecked){
                    saveDataRegistation = true;
                }else{
                    saveDataRegistation = false;
                }
            }
        });

        TextView tvAccedi = v.findViewById(R.id.tvRegistrati);
        tvAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                NavHostFragment.findNavController(RegistrationFragment.this).navigate(R.id.action_registrationFragment_to_loginFragment);
            }
        });

        Button btRegistrati = v.findViewById(R.id.btSendFrinedshipRequest);
        CustomDialog dialog = new CustomDialog();// custom dialog is a extends of DialogFragment to have a dialog with custom look :)

        btRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                /*check if the value in conferm email field is the same in email field*/
                if(!email.getText().toString().equals(confermaEmail.getText().toString())){
                    Log.d(TAG, "email "+email.getText().toString()+"conferma email "+confermaEmail.getText().toString());
                    dialog.setDialogWrong("Email e conferma email non combaciano");
                    dialog.show(getFragmentManager(),"CustomDialog");
                    return;
                }
                /*check if the value in conferm password field is the same in password field*/
                else if (!password.getText().toString().equals(confermaPassword.getText().toString())){
                    Log.d(TAG, "password "+password.getText().toString()+" conferma password"+confermaPassword.getText().toString());
                    dialog.setDialogWrong("Password e conferma password non combaciano");
                    dialog.show(getFragmentManager(),"CustomDialog");
                    return;
                }
                /*check if some field is empty and if is minimun one is empty trigger the customdialog to show the warning message*/
                else if(email.getText().toString().equals("") ||
                        confermaEmail.getText().toString().equals("") ||
                        password.getText().toString().equals("") ||
                        confermaPassword.getText().toString().equals("") ||
                        username.getText().toString().equals("")){
                        Log.d(TAG, "email "+email.getText().toString()+" conferma email "+confermaEmail.getText().toString()
                        + " password "+password.getText().toString()+" conferma password"+confermaPassword.getText().toString()
                        + "username "+username.getText().toString());
                        dialog.setDialogWrong("Nessun campo deve essere lasciato vuoto");
                        dialog.show(getFragmentManager(),"CustomDialog");
                        return;
                }

                //prepare json to make request of registration at the backe-end
                String json_string = "{\n" +
                        "    user:{\n" +
                        "        idUser : 0,\n" + // idUser is 0 beacuse is the back-end logic to decide the id
                        "        username :"+ username.getText() +",\n" +
                        "        genere : true,\n" + //TO DO : TAKE VALUE FROM FORM REGISTRATION USER
                        "        idPokedex : 0,\n" + // idPokedex is 0 beacuse is the back-end logic to decide the id
                        "        codiceAmico : \"amico\"\n" + //TO DO : MAKE GENERATED FRIEND CODE
                        "    }\n" +
                        "    ,\n" +
                        "    utente:{\n" +
                        "        idUtente : 0,\n" + // idUtente is 0 beacuse is the back-end logic to decide the id
                        "        email : "+ email.getText() +",\n" +
                        "        password : "+ password.getText() +"\n" +
                        "    }\n" +
                        "}";

                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(json_string); // make a json string in a json object
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                String url = getResources().getString(R.string.base_url)+"UtenzaServlet";
                /*prepare request to do at back-end, this ios a POST*/
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                    Log.d(TAG, "onResponse() called with: response = [" + response + "]");
                                    if(response != null){// if response is OK attivate dialog to comunicate user the right bheaviour
                                        dialog.setDialogRight("Account reggistrato correttamente");
                                        dialog.show(getFragmentManager(),"CustomDialog");
                                    }
                                    /*IN THIS IF AND ELSE CODE BLOCK, THERE IS A CHECK ABOUT THE USER ACTIVATION
                                    OF THE OPTION TO REMAIN AUTHENTICATE WHEN CLOSE APP AND RESTART IN A SECOND MOMENT*/
                                    if(saveDataRegistation){
                                        Thread t = null;
                                        try {
                                            t = new Thread(new SaveUserDataLocalDBRunnable(new User(1,
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

                                            t = new Thread(new SaveUserDataLocalDBRunnable(new User(1,
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
                                Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                            }
                        });
                // send request with a instance of singleton VOLLEY network android tool
                SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);
            }
        });

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
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

    public class CeckLocalDBRunnable implements Runnable {

        public CeckLocalDBRunnable() { }

        public void run() {
            Log.d(TAG, "run() called");
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());
            db.userDao().getAll();
        }
    }
}

