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
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.fragment.dialog.CustomDialog;
import it.cudia.studio.android.pokedroid.request.BooleanRequest;
import it.cudia.studio.android.pokedroid.singleton.LocalDB;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;
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
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        setHasOptionsMenu(true);

        // Get a RequestQueue
        RequestQueue queue = SingletonVolley.getInstance(getActivity().getApplicationContext()).
                getRequestQueue();

        LocalDB localDB = LocalDB.getInstance(getActivity().getApplicationContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_registration, container, false);

        EditText email = v.findViewById(R.id.etEmail);
        EditText confermaEmail = v.findViewById(R.id.etConfermaEmail);
        EditText password = v.findViewById(R.id.etPasswordAccedi);
        EditText confermaPassword = v.findViewById(R.id.etConfermaPassword);
        EditText username =  v.findViewById(R.id.etUsername);
        RadioGroup genere = v.findViewById(R.id.genere);

        TextView tvAccedi = v.findViewById(R.id.tvRegistrati);
        tvAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(RegistrationFragment.this).navigate(R.id.action_registrationFragment_to_loginFragment);
            }
        });

        Button btRegistrati = v.findViewById(R.id.btListaAmici);
        CustomDialog dialog = new CustomDialog();

        btRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");

                if(!email.getText().toString().equals(confermaEmail.getText().toString())){
                    Log.d(TAG, "email "+email.getText().toString()+"conferma email "+confermaEmail.getText().toString());
                    dialog.setDialogWrong("Email e conferma email non combaciano");
                    dialog.show(getFragmentManager(),"CustomDialog");
                    return;
                }else if (!password.getText().toString().equals(confermaPassword.getText().toString())){
                    Log.d(TAG, "password "+password.getText().toString()+" conferma password"+confermaPassword.getText().toString());
                    dialog.setDialogWrong("Password e conferma password non combaciano");
                    dialog.show(getFragmentManager(),"CustomDialog");
                    return;
                }else if(email.getText().toString().equals("") ||
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

                String json_string = "{\n" +
                        "    user:{\n" +
                        "        idUser : 0,\n" +
                        "        username :"+ username.getText() +",\n" +
                        "        genere : true,\n" +
                        "        idPokedex : 0,\n" +
                        "        codiceAmico : \"amico\"\n" +
                        "    }\n" +
                        "    ,\n" +
                        "    utente:{\n" +
                        "        idUtente : 0,\n" +
                        "        email : "+ email.getText() +",\n" +
                        "        password : "+ password.getText() +"\n" +
                        "    }\n" +
                        "}";

                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(json_string);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                //NavHostFragment.findNavController(RegistrationFragment.this).navigate(R.id.action_registrationFragment_to_listaPokemonFragment);
                String url = getResources().getString(R.string.base_url)+"UtenzaServlet";
                BooleanRequest jsonObjectRequest = new BooleanRequest
                        (Request.Method.POST, url, json_string, new Response.Listener<Boolean>() {
                            @Override
                            public void onResponse(Boolean response) {

                                    Log.d(TAG, "onResponse() called with: response = [" + response + "]");
                                    if(response){
                                        dialog.setDialogRight("Account reggistrato correttamente");
                                        dialog.show(getFragmentManager(),"CustomDialog");
                                    }
                                    NavHostFragment.findNavController(RegistrationFragment.this).navigate(R.id.action_registrationFragment_to_listaPokemonFragment);
                            }
                        }
                        , new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error
                                Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                            }
                        });

                SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);

            }

        });

        return v;
    }



    @Override
    public void onStart() {
        super.onStart();
        PokedroidToolbar.disableBackNavigation();
       // PokedroidToolbar.enableProfileIcon();
       // MenuItem item = menu.findItem(R.id.menu_profile);
        //item.setVisible(false);
        //PokedroidToolbar.disableProfileIcon();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu,menuInflater);

        PokedroidToolbar.disableProfileIcon();

    }


}