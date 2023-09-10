package it.cudia.studio.android.pokedroid.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
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
import java.util.logging.LogManager;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.fragment.RegistrationFragment;
import it.cudia.studio.android.pokedroid.fragment.RiscattaPokemonFragment;
import it.cudia.studio.android.pokedroid.fragment.dialog.CustomDialog;
import it.cudia.studio.android.pokedroid.model.AppDatabase;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;
import it.cudia.studio.android.pokedroid.singleton.SingletonVolley;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    PokedroidToolbar pokedroidToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        pokedroidToolbar = PokedroidToolbar.getInstance((Toolbar)findViewById(R.id.toolbar));
        PokedroidToolbar.setActivity(MainActivity.this);
        pokedroidToolbar.setActionBar(Objects.requireNonNull(getSupportActionBar()));
        PokedroidToolbar.setInflater(getMenuInflater());

        Thread t = new Thread(new MyRunnable());
        t.start();


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
            } else {
                // if the intentResult is not null we'll set
                // the content and format of scan message
                Log.d(TAG, "onActivityResult() called with QR: " + intentResult.getContents());
                RiscattaPokemonFragment riscattaPokemonFragment = new RiscattaPokemonFragment();
               /* Bundle bundle = new Bundle();
                bundle.putString("QrText",);*/
                Thread t = new Thread(new MainActivity.RetrivePokedexIdLocalDBUseQrRunnable(intentResult.getContents()));
                t.start();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
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

    public class RetrivePokedexIdLocalDBUseQrRunnable implements Runnable {

        String qrText;
        public RetrivePokedexIdLocalDBUseQrRunnable(String qrText) {
            this.qrText = qrText;
        }

        public void run() {
            Log.d(TAG, "run() called");
            AppDatabase db = AppDatabase.getInstance(getBaseContext());

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
                                        dialog.setDialogRight("nuovo pokemon riscattato con successo!");
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
}

