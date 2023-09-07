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
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access);

        Thread t = new Thread(new AccessActivity.MyRunnable());// instantiate thread to start check if user is yet logged
        t.start(); // start thread
    }
    public class MyRunnable implements Runnable {

        public MyRunnable() {

        }

         public void run() {
            /*get instance SINGLETON database "manager" to use Room db android tool*/
            AppDatabase db = AppDatabase.getInstance(AccessActivity.this);
            /*check if user is yet authenticated*/
            if (db.userDao().loadUserUsername(1)!=null) {
                Log.d(TAG, "run() called and user is yet authenticated");
                Intent intent  =  new Intent(AccessActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Log.d(TAG, "run() called and user is not yet authenticated");
                db.userDao().getAll();
            }
        }
    }
}