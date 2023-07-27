package it.cudia.studio.android.pokedroid.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import it.cudia.studio.android.pokedroid.model.dao.UserDao;
import it.cudia.studio.android.pokedroid.model.entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
