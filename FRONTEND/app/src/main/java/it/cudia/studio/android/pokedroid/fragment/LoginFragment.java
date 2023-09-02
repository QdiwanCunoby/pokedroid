package it.cudia.studio.android.pokedroid.fragment;

import android.content.Intent;
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
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.activity.AccessActivity;
import it.cudia.studio.android.pokedroid.activity.MainActivity;
import it.cudia.studio.android.pokedroid.fragment.dialog.CustomDialog;
import it.cudia.studio.android.pokedroid.request.BooleanRequest;
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
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        TextView tvRegistrati = v.findViewById(R.id.tvRegistrati);
        tvRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_registrationFragment);
            }
        });

        EditText email = v.findViewById(R.id.etEmailAccedi);
        EditText password = v.findViewById(R.id.etPasswordAccedi);

        Button btAccedi = v.findViewById(R.id.btListaAmici);
        CustomDialog dialog = new CustomDialog();
        //dialog.SetCanceledOnTouchOutside(true);


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
                BooleanRequest jsonObjectRequest = new BooleanRequest
                        (Request.Method.GET, url, null, new Response.Listener<Boolean>() {
                            @Override
                            public void onResponse(Boolean response) {
                                Log.d(TAG, url);
                                Log.d(TAG, "onResponse() called with: response = [" + response + "]");
                                if(response){
                                    dialog.setDialogRight("Loggin effettuato correttamente");
                                    dialog.show(getFragmentManager(),"CustomDialog");

                                    //NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_listaPokemonFragment);
                                }else {
                                    dialog.setDialogWarning("Loggin effettuato non corretto");
                                    dialog.show(getFragmentManager(),"CustomDialog");
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

                SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);

            }

        });

        return v;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu,menuInflater);
        //getMenuInflater().inflate(R.menu.menu_profile, menu);
        PokedroidToolbar.disableProfileIcon();
    }
}