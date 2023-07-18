package it.cudia.studio.android.pokedroid.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
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
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;

public class MainActivity extends AppCompatActivity {

    PokedroidToolbar pokedroidToolbar;
    TextView tvAccedi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        pokedroidToolbar = PokedroidToolbar.getInstance((Toolbar)findViewById(R.id.toolbar));
        PokedroidToolbar.setActivity(MainActivity.this);

        pokedroidToolbar.setActionBar(Objects.requireNonNull(getSupportActionBar()));
        PokedroidToolbar.setInflater(getMenuInflater());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        PokedroidToolbar.setMenu(menu);
        PokedroidToolbar.enableProfileIcon();

        return true;
    }
}