package it.cudia.studio.android.pokedroid.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.model.AppDatabase;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "SplashActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread t = new Thread(new CheckIfUserAuthIsToRemoveRunnable());
        t.start();
    }

    public class CheckIfUserAuthIsToRemoveRunnable implements Runnable {

        public CheckIfUserAuthIsToRemoveRunnable() {

        }

        public void run() {
            /*get instance SINGLETON database "manager" to use Room db android tool*/
            AppDatabase db = AppDatabase.getInstance(SplashActivity.this);
            /*check if user in local DB is no yet authenticated*/
            if (db.userDao().loadUserUsername(1)!=null && db.userDao().loadUserAccesso(1) == 0) {
                Log.d(TAG, "run() called and user is no yet authenticated");
                db.userDao().deleteById(1);
            }
        }
    }
}