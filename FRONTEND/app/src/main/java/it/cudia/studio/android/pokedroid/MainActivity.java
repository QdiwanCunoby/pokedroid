package it.cudia.studio.android.pokedroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;
import java.util.logging.LogManager;

public class MainActivity extends AppCompatActivity {

    Toolbar pokedroidToolbar;
    TextView tvAccedi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokedroidToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(pokedroidToolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pokedroidToolbar.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }
}