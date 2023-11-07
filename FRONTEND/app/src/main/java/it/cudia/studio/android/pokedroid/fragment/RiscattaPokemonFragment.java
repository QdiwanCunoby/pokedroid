package it.cudia.studio.android.pokedroid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.zxing.integration.android.IntentIntegrator;

import org.json.JSONException;
import org.json.JSONObject;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.activity.CaptureActivityPortrait;
import it.cudia.studio.android.pokedroid.fragment.dialog.CustomDialog;
import it.cudia.studio.android.pokedroid.model.AppDatabase;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;
import it.cudia.studio.android.pokedroid.singleton.SingletonVolley;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RiscattaPokemonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RiscattaPokemonFragment extends Fragment {

    private static final String TAG = "RiscattaPokemonFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText etCodicePokemon;
    Button btRiscattaPokemon;
    Button btQrRiscattaPokemon;



    public RiscattaPokemonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RiscattaPokemonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RiscattaPokemonFragment newInstance(String param1, String param2) {
        RiscattaPokemonFragment fragment = new RiscattaPokemonFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        requireActivity().getSupportFragmentManager();
        View view =  inflater.inflate(R.layout.fragment_riscatta_pokemon, container, false);
        etCodicePokemon = view.findViewById(R.id.etEmailAmico);
        btRiscattaPokemon = view.findViewById(R.id.btSendFrinedshipRequest);
        btQrRiscattaPokemon = view.findViewById(R.id.btQrScannerFriendship);
        CustomDialog dialog = new CustomDialog();
        btRiscattaPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with:"+ etCodicePokemon.getText().toString());
                if(etCodicePokemon.getText().toString().equals("")){
                    Log.d(TAG, "onClick() called inner if with :"+ etCodicePokemon.getText().toString());
                    dialog.setDialogWrong("il campo per il codice di riscatto del pokemon e' vuoto!");
                    dialog.show(getFragmentManager(),"CustomDialog");
                }else{
                    Thread t = new Thread( new RetrivePokedexIdLocalDBRunnable());
                    t.start();

                }
            }
        });

        btQrRiscattaPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // we need to create the object
                // of IntentIntegrator class
                // which is the class of QR library
                IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
                intentIntegrator.setPrompt("Scan a barcode or QR Code");
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setCaptureActivity(CaptureActivityPortrait.class);
                intentIntegrator.initiateScan();
            }
        });



        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onCreateView() called with: inflater PASSAGGIO");
        if(getArguments()!=null){
            Log.d(TAG, "onCreateView() called with: inflater PASSAGGIO =" + getArguments());
            if(getArguments().getString("QrText")!=null){
                Log.d(TAG, "onCreateView() called with: inflater PASSAGGIO =" + getArguments().getString("QrText"));
                Thread t = new Thread(new RetrivePokedexIdLocalDBUseQrRunnable(getArguments().getString("QrText")));
                t.start();


            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu,menuInflater);

        PokedroidToolbar.enableBackNavigation();
        menu.findItem(R.id.menu_profile).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                NavHostFragment.findNavController(RiscattaPokemonFragment.this).navigate(R.id.action_riscattaPokemonFragment_to_profileFragment);
                return true;
            }
        });
    }

    public class RetrivePokedexIdLocalDBRunnable implements Runnable {

        Handler handler;
        public RetrivePokedexIdLocalDBRunnable() { }


        @Override
        public void run() {

            LooperThread looperThread = new LooperThread();
            looperThread.start();
            Log.d(TAG, "run() called");
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());

            String json_string = null;
            if(db.userDao().loadUserUsername(1)!=null) {

                //prepare json to make request of registration at the backe-end
                json_string = "{\n" +
                        "    codice: '"+ etCodicePokemon.getText().toString() +"',\n" +
                        "    idPokedex : "+ db.userDao().loadUserPokedex(1) +"\n" +
                        "}";
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(json_string); // make a json string in a json object
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                String url = getResources().getString(R.string.base_url)+"PokemonServlet";

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                CustomDialog dialog = new CustomDialog();
                                Log.d(TAG, "onResponse() called with: response = [" + response + "]");
                                try {
                                    if(response.getString("esito").equals("false")){
                                        dialog.setDialogWrong("il codice di riscatto non e' corretto!");

                                    }else if(response.getString("esito").equals("already inserted")){
                                        dialog.setDialogWarning("il pokemon e' gia' stato riscattato!");

                                    }else if(response.getString("esito").equals("true")){
                                        dialog.setDialogSuccessRiscattaPokemon("nuovo pokemon riscattato con successo!",getParentFragmentManager());
                                        looperThread.handler.post(new SaveAvanzamentoPokedexDBlocal());

                                    }else{
                                        dialog.setDialogWrong("qualcosa e' andato storto, si e' verificato un disservizio!");
                                    }
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                                dialog.show(getFragmentManager(),"CustomDialog");
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error
                                Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                            }
                        });

                // send request with a instance of singleton VOLLEY network android tool
                SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);

            }


        }
    }

   public class LooperThread extends Thread{
       public Handler handler;

       @Override
       public void run() {
           Looper.prepare();
           handler = new Handler();
           Looper.loop();
       }
   }

    public  class SaveAvanzamentoPokedexDBlocal implements  Runnable{

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

                                    new Thread(new PokemonAdvancementUpdate(response.getInt("avanzamento"))).start();
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

    public class PokemonAdvancementUpdate implements Runnable{

        int v;
        PokemonAdvancementUpdate(int v){
            this.v = v;
        }

        @Override
        public void run() {
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());
            db.userDao().UpdateAvanzamentoPokedex((int)calcolaPercentuale(this.v,151));
        }
    }

    public double calcolaPercentuale(double numero, double totale) {
        if (totale == 0) {
            throw new IllegalArgumentException("Il totale non può essere zero.");
        }

        double percentuale = (numero / totale) * 100;
        return percentuale;
    }

    public class RetrivePokedexIdLocalDBUseQrRunnable implements Runnable {

        String qrText;
        public RetrivePokedexIdLocalDBUseQrRunnable(String qrText) {
            this.qrText = qrText;
        }

        public void run() {
            Log.d(TAG, "run() called");
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());
            LooperThread looperThread = new LooperThread();
            looperThread.start();
            String json_string = null;
            if(db.userDao().loadUserUsername(1)!=null) {

                //prepare json to make request of registration at the backe-end
                json_string = "{\n" +
                        "    codice: '"+ this.qrText +"',\n" +
                        "    idPokedex : "+ db.userDao().loadUserPokedex(1) +"\n" +
                        "}";
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(json_string); // make a json string in a json object
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                String url = getResources().getString(R.string.base_url)+"PokemonServlet";
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                CustomDialog dialog = new CustomDialog();
                                Log.d(TAG, "onResponse() called with: response = [" + response + "]");
                                try {
                                    if(response.getString("esito").equals("false")){
                                        dialog.setDialogWrong("il codice di riscatto non e' corretto!");
                                    }else if(response.getString("esito").equals("already inserted")){
                                        dialog.setDialogWarning("il pokemon e' gia' stato riscattato!");

                                    }else if(response.getString("esito").equals("true")){
                                        dialog.setDialogSuccessRiscattaPokemon("nuovo pokemon riscattato con successo!",getParentFragmentManager());

                                        looperThread.handler.post(new SaveAvanzamentoPokedexDBlocal());

                                    }else {
                                        dialog.setDialogWrong("qualcosa e' andato storto, si e' verificato un disservizio!");
                                    }
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                                dialog.show(getFragmentManager(),"CustomDialog");
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error
                                Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                            }
                        });
                // send request with a instance of singleton VOLLEY network android tool
                SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);
            }


        }
    }
}