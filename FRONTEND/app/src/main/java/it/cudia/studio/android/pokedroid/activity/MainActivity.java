package it.cudia.studio.android.pokedroid.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.fragment.ListaPokemonFragment;
import it.cudia.studio.android.pokedroid.fragment.ProfileFragment;
import it.cudia.studio.android.pokedroid.fragment.RiscattaPokemonFragment;
import it.cudia.studio.android.pokedroid.fragment.dialog.CustomDialog;
import it.cudia.studio.android.pokedroid.model.AppDatabase;
import it.cudia.studio.android.pokedroid.services.MyFirebaseInstanceIDService;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;
import it.cudia.studio.android.pokedroid.singleton.SingletonVolley;
import kotlinx.coroutines.Dispatchers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    PokedroidToolbar pokedroidToolbar;
    ImageView imgProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        pokedroidToolbar = PokedroidToolbar.getInstance((Toolbar)findViewById(R.id.toolbar));
        PokedroidToolbar.setActivity(MainActivity.this);
        pokedroidToolbar.setActionBar(Objects.requireNonNull(getSupportActionBar()));
        PokedroidToolbar.setInflater(getMenuInflater());
        invalidateOptionsMenu();
        Thread t = new Thread(new MyRunnable());
        t.start();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult() called with: requestCode = [" + requestCode + "], resultCode = [" + resultCode + "], data = [" + data + "]");
        // if the intentResult is null then
        // toast a message as "cancelled"
        if (intentResult != null) {
            if (intentResult.getContents() == null) {
                Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            }else if(intentResult.getContents().length() == MyFirebaseInstanceIDService.getToken(getBaseContext()).length()){
                Thread t = new Thread(new MainActivity.SendNotiphicationFriendshipRunnable(intentResult.getContents()));
                t.start();
            }else if(intentResult.getContents().length() == String.valueOf("MEMTLXGOYAGG").length()){
                // if the intentResult is not null we'll set
                // the content and format of scan message
                Log.d(TAG, "onActivityResult() called with QR: " + intentResult.getContents());
                RiscattaPokemonFragment riscattaPokemonFragment = new RiscattaPokemonFragment();

                Thread t = new Thread(new MainActivity.RetrivePokedexIdLocalDBUseQrRunnable(intentResult.getContents()));
                t.start();
            }
        }else if(data.getData() != null){
            Thread t = new Thread(new SaveProfileImageRunnable(data.getData().toString()));
            t.start();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent() called with: intent = [" + intent + "]");
        CustomDialog dialog = new CustomDialog();
        if(intent.getExtras() != null){
            if(intent.getStringExtra("methodName").equals("acceptFriend")){
                Log.d(TAG, "acceptFriend");
                dialog.setDialogRight(" hai accettato la richiesta di amicizia!");
                dialog.show(getSupportFragmentManager(),"CustomDialog");

                Thread t = new Thread(new sendFriendshipRequest(intent.getStringExtra("usernameMandante")));
                t.start();
            } else if (intent.getStringExtra("methodName").equals("discardFriend")) {
                Log.d(TAG, "discardFriend");
                dialog.setDialogWarning("non hai accettato la richiesta di amicizia!");
                dialog.show(getSupportFragmentManager(),"CustomDialog");
            }
        }
    }

    @Override
    public void onBackPressed() {

        Fragment f = getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if(f instanceof ListaPokemonFragment) {
            Log.d(TAG, "onBackPressed() called and go back 1");
        } else {
            Log.d(TAG, "onBackPressed() called and go back 2");
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        PokedroidToolbar.setMenu(menu);
        PokedroidToolbar.enableProfileIcon();

        return true;
    }

    public class MyRunnable implements Runnable {

        public MyRunnable() {

        }

        public void run() {

            AppDatabase db = AppDatabase.getInstance(MainActivity.this);


                Log.d(TAG, "run() called");

                db.userDao().getAll();

        }
    }

    public class MakeQuery implements Runnable{

        int v;
        MakeQuery(int v){
            this.v = v;
        }

        @Override
        public void run() {
            AppDatabase db = AppDatabase.getInstance(getApplicationContext());
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

    public class SaveAvanzamentoPokedexDBlocal implements Runnable{

        public SaveAvanzamentoPokedexDBlocal(){}

        @Override
        public void run() {
            AppDatabase db = AppDatabase.getInstance(getBaseContext());
            if(db.userDao().loadUserUsername(1)!=null){
                JsonObjectRequest jsonObjectRequestGet = null;
                int idPokedex = db.userDao().loadUserPokedex(1);
                Log.d(TAG, "onResponse() called with: response idPokedex = [" + idPokedex + "]");
                if(idPokedex!=0){
                    String urlGet = getResources().getString(R.string.base_url) + "PokedexServlet?pokedex="+db.userDao().loadUserPokedex(1);

                    jsonObjectRequestGet = new JsonObjectRequest
                            (Request.Method.GET, urlGet, null, new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        new Thread(new MakeQuery(response.getInt("avanzamento"))).start();
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

                    SingletonVolley.getInstance(getBaseContext()).addToRequestQueue(jsonObjectRequestGet);
                }
            }
            

        }
    }

    public class sendFriendshipRequest implements Runnable {
        //String usernameRiceventeRichiesta;
        String usernameMandanteRichiesta;
        public sendFriendshipRequest( String usernameMandanteRichiesta ) {
            this.usernameMandanteRichiesta = usernameMandanteRichiesta;
        }

        public void run() {

            AppDatabase db = AppDatabase.getInstance(MainActivity.this);
            Log.d(TAG, "run() called");
            if(db.userDao().loadUserUsername(1) != null) {
                String json_string = "{\n" +
                        "    mandante : '" + usernameMandanteRichiesta + "',\n" +
                        "    ricevente : '" + db.userDao().loadUserUsername(1) + "'\n" +
                        "}";
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(json_string); // make a json string in a json object
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                String url = getResources().getString(R.string.base_url)+"AmiciziaServlet";
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        if(response.toString().equals("accept friendship")){
                            Log.d(TAG, "onResponse() called with: response = [" + response.toString() + "]");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                // send request with a instance of singleton VOLLEY network android tool
                SingletonVolley.getInstance(getBaseContext()).addToRequestQueue(jsonObjectRequest);
            }
        }
    }

    public class RetrivePokedexIdLocalDBUseQrRunnable implements Runnable {
        Handler handler;
        String qrText;
        public RetrivePokedexIdLocalDBUseQrRunnable(String qrText) {
            this.qrText = qrText;
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
        public void run() {
            LooperThread looperThread = new LooperThread();
            looperThread.start();

            Log.d(TAG, "run() called");
            AppDatabase db = AppDatabase.getInstance(getBaseContext());

            String json_string = null;
            if(db.userDao().loadUserUsername(1)!=null) {

                //prepare json to make request of registration at the backe-end
                json_string = "{\n" +
                        "    codice: '"+ this.qrText +"',\n" +
                        "    idPokedex : '"+ db.userDao().loadUserPokedex(1) +"'\n" +
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
                                        dialog.setDialogRight("nuovo pokemon riscattato con successo!");
                                        looperThread.handler.post(new SaveAvanzamentoPokedexDBlocal());

                                    }else{
                                        dialog.setDialogWrong("qualcosa e' andato storto, si e' verificato un disservizio!");
                                    }
                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                                dialog.show(getSupportFragmentManager(),"CustomDialog");
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error
                                Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                            }
                        });
                // send request with a instance of singleton VOLLEY network android tool
                SingletonVolley.getInstance(getBaseContext()).addToRequestQueue(jsonObjectRequest);
            }


        }
    }

    public class SendNotiphicationFriendshipRunnable implements Runnable {

        String qrText;
        public SendNotiphicationFriendshipRunnable(String qrText) {
            this.qrText = qrText;
        }

        public void run() {
            String url = getResources().getString(R.string.base_url)+"NotificationServlet";

            AppDatabase db = AppDatabase.getInstance(getBaseContext());

            String json_string = null;
            if(db.userDao().loadUserUsername(1)!=null) {
                json_string = "{\n" +
                        "    username: '"+ db.userDao().loadUserUsername(1) +"',\n" +
                        "    token : '"+ qrText +"'\n" +
                        "}";
                JSONObject jsonObject;
                try {
                    jsonObject = new JSONObject(json_string); // make a json string in a json object
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {}
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // TODO: Handle error
                                Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                            }
                        });
                // send request with a instance of singleton VOLLEY network android tool
                SingletonVolley.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
            }
        }
    }

    public class SaveProfileImageRunnable implements Runnable{

        String uri_img_profile;

        SaveProfileImageRunnable( String uri_img_profile){
            this.uri_img_profile = uri_img_profile;
        }

        @Override
        public void run() {
            AppDatabase db = AppDatabase.getInstance(getApplicationContext());

            db.userDao().updateImgProfile(this.uri_img_profile);

            FragmentManager fragmentManager = getSupportFragmentManager();
            ProfileFragment profilo = new ProfileFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.profileFragmentContainer, profilo)
                    .commit();
        }
    }
}


