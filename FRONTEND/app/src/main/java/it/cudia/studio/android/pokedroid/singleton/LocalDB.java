package it.cudia.studio.android.pokedroid.singleton;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import it.cudia.studio.android.pokedroid.model.AppDatabase;
import it.cudia.studio.android.pokedroid.model.dao.UserDao;

public final class LocalDB {

    private static final String TAG = "LocalDB";

    private static LocalDB INSTANCE;

    public static AppDatabase DB_locale;

    private LocalDB(Context context){
        DB_locale = Room.databaseBuilder(context,
                AppDatabase.class, "pokedroid").build();
    }

    public static LocalDB getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new LocalDB(context);
        }

        return INSTANCE;
    }

    public static UserDao userDao(){
        return DB_locale.userDao();
    }


}
