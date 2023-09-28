package it.cudia.studio.android.pokedroid.singleton;

import android.content.ClipData;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.activity.MainActivity;
import it.cudia.studio.android.pokedroid.fragment.RegistrationFragment;

public final class PokedroidToolbar {

    private static PokedroidToolbar INSTANCE;
    private static AppCompatActivity activity;
    private static Toolbar toolbar;
    private static ActionBar actionBar;
    private static Menu menu;

    private static MenuItem profileIcon;

    public static Menu getMenu() {
        return menu;
    }

    public static void setMenu(Menu menu) {
        PokedroidToolbar.menu = menu;
    }

    public static AppCompatActivity getActivity() {
        return activity;
    }

    public static void setActivity(AppCompatActivity activity) {
        PokedroidToolbar.activity = activity;
    }

    private static  MenuInflater inflater;

    private String info = "This is use design pattern singleton to manage Toolbar android";

    private PokedroidToolbar(Toolbar toolBar){
        setToolbar(toolBar);
    }

    public static PokedroidToolbar getInstance(Toolbar toolBar) {
        if(INSTANCE == null){

            INSTANCE = new PokedroidToolbar(toolBar);
        }

        return INSTANCE;
    }

    public String getInfo() {
        return info;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
        this.toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_ios_24);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity.getSupportFragmentManager().getBackStackEntryCount() > 0){
                    boolean done = activity.getSupportFragmentManager().popBackStackImmediate();
                }
                activity.getSupportFragmentManager().executePendingTransactions();
                activity.getSupportFragmentManager().popBackStack();

            }
        });
    }

    public ActionBar getActionBar() {
        return actionBar;
    }

    public void setActionBar(ActionBar actionBar) {
        this.actionBar = actionBar;
        this.actionBar.setDisplayHomeAsUpEnabled(true);
        this.actionBar.setDisplayShowHomeEnabled(true);
    }

    public static MenuInflater getInflater() {
        return inflater;
    }

    public static void setInflater(MenuInflater inflater) {
        PokedroidToolbar.inflater = inflater;
    }

    public static void disableBackNavigation() {
        actionBar.setDisplayHomeAsUpEnabled(false);
    }

    public static void enableBackNavigation() {
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public static void enableProfileIcon() {
        getInflater().inflate(R.menu.menu_profile, menu);
        MenuItem profileIcon = menu.findItem(R.id.menu_profile);

    }


    public static void disableProfileIcon() {
        profileIcon = menu.findItem(R.id.menu_profile);
        profileIcon.setVisible(false);
    }

    public static MenuItem setOnClickProfileIconFragmentNavigation(Fragment fragment, int navigation){

       return profileIcon.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                NavHostFragment.findNavController(fragment).navigate(navigation);
                return true;
            }
        });
    }


}
