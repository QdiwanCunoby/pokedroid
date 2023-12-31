package it.cudia.studio.android.pokedroid.model.dao;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.DeleteTable;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import it.cudia.studio.android.pokedroid.model.entity.User;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT user_username FROM user WHERE uid = :userId")
    String loadUserUsername(int userId);

    @Query("SELECT user_email FROM user WHERE uid = :userId")
    String loadUserEmail(int userId);
    @Query("SELECT profile_image FROM user WHERE uid = :userId")
    String loadUserProfileImage(int userId);

    @Query("SELECT user_password FROM user WHERE uid = :userId")
    String loadUserPassword(int userId);

    @Query("SELECT pokedex_completamento FROM user WHERE uid = :userId")
    Double loadAvanzamentoPokedex(int userId);

    @Query("UPDATE user SET pokedex_completamento = :avanzamento")
    void UpdateAvanzamentoPokedex(int avanzamento);

    @Query("SELECT user_pokedex FROM user WHERE uid = :userId")
    int loadUserPokedex(int userId);

    @Query("SELECT accesso FROM user WHERE uid = :userId")
    int loadUserAccesso(int userId);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user WHERE uid = :id")
    void deleteById(int id);

    @Query("UPDATE user SET profile_image = :img")
    void updateImgProfile(String img);
    @Query("UPDATE user SET user_password = :password")
    void updatePassword(String password);

}

class UserCredential {
    public String email;
    public String password;
}
