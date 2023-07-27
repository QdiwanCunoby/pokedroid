package it.cudia.studio.android.pokedroid.model.dao;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import it.cudia.studio.android.pokedroid.model.entity.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT user_username FROM user WHERE uid = :userId")
    String loadUserUsername(String userId);

    @Query("SELECT user_email FROM user WHERE uid = :userId")
    String loadUserEmail(String userId);

    @Query("SELECT user_password FROM user WHERE uid = :userId")
    String loadUserPassword(String userId);


    @Query("SELECT user_pokedex FROM user WHERE uid = :userId")
    int loadUserPokedex(String userId);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);
}

class UserCredential {
    public String email;
    public String password;
}
