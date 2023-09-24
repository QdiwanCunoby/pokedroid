package it.cudia.studio.android.pokedroid.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey
    private int uid;

    @ColumnInfo (name = "user_username")
    private String username;

    @ColumnInfo (name = "user_genere")
    private boolean genere;

    @ColumnInfo (name= "user_email")
    private String email;

    @ColumnInfo (name= "user_password")
    private String password;

    @ColumnInfo (name= "user_pokedex")
    private int pokedex;

    @ColumnInfo(name="user_codice_amico")
    private String codiceAmico;

    @ColumnInfo(name="pokedex_completamento")
    private float pokedexCompletamento;

    @ColumnInfo(name="profile_image")
    private String profileImage;

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public User(int uid, String username, String email,
                String password, int pokedex, String codiceAmico,
                float pokedexCompletamento , boolean genere, boolean accesso) {
        this.uid = uid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.pokedex = pokedex;
        this.codiceAmico = codiceAmico;
        this.pokedexCompletamento = pokedexCompletamento;
        this.genere = genere;
        this.accesso = accesso;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isGenere() {
        return genere;
    }

    public void setGenere(boolean genere) {
        this.genere = genere;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPokedex() {
        return pokedex;
    }

    public void setPokedex(int pokedex) {
        this.pokedex = pokedex;
    }

    public String getCodiceAmico() {
        return codiceAmico;
    }

    public void setCodiceAmico(String codiceAmico) {
        this.codiceAmico = codiceAmico;
    }

    public float getPokedexCompletamento() {
        return pokedexCompletamento;
    }

    public void setPokedexCompletamento(float pokedexCompletamento) {
        this.pokedexCompletamento = pokedexCompletamento;
    }

    public boolean isAccesso() {
        return accesso;
    }

    public void setAccesso(boolean accesso) {
        this.accesso = accesso;
    }

    @ColumnInfo(name= "accesso")
    private boolean accesso;


}
