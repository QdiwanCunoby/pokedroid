package it.cudia.studio.android.pokedroid.activity;

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

import java.util.Objects;
import java.util.logging.LogManager;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.fragment.RegistrationFragment;
import it.cudia.studio.android.pokedroid.model.AppDatabase;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;

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
}

