package it.cudia.studio.android.pokedroid.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    public int uid;

    @ColumnInfo (name = "user_username")
    public String username;

    @ColumnInfo (name= "user_email")
    public String email;

    @ColumnInfo (name= "user_password")
    public String password;

    @ColumnInfo (name= "user_pokedex")
    public int pokedex;
}
