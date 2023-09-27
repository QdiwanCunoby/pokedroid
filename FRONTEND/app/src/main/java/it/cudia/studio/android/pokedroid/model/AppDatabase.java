package it.cudia.studio.android.pokedroid.model;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import it.cudia.studio.android.pokedroid.model.dao.UserDao;
import it.cudia.studio.android.pokedroid.model.entity.User;

@Database(entities = {User.class}, exportSchema = false, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    private static final String TAG = "AppDatabase";
    private static AppDatabase INSTANCE;
    private static String DB_NAME = "localPokedroid.db";

    public static synchronized AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            Log.d(TAG, "getInstance() called with: context = [" + context + "]");
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class,DB_NAME).fallbackToDestructiveMigration().build();
        }

        return INSTANCE;
    }
    public abstract UserDao userDao();
}
