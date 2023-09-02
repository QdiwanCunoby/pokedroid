package it.cudia.studio.android.pokedroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.model.AppDatabase;

public class AccessActivity extends AppCompatActivity {

    private static final String TAG = "AccessActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);

        Thread t = new Thread(new AccessActivity.MyRunnable());
        t.start();
    }
    public class MyRunnable implements Runnable {

        public MyRunnable() {

        }

    public void run() {

        AppDatabase db = AppDatabase.getInstance(AccessActivity.this);

        if (db.userDao().loadUserUsername(1)!=null) {
            Log.d(TAG, "run() called and DB exist");
            Intent intent  =  new Intent(AccessActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Log.d(TAG, "run() called");

            db.userDao().getAll();
        }
        }
    }
}