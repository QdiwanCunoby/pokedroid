package it.uniroma2.cudia.pokedroid.entity;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

	private long idUser;
	private String username;
	private boolean genere;
	private long idPokedex;
	private String codiceAmico;
	
	public User(long idUser, String username, boolean genere, long idPokedex, String codiceAmico) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.genere = genere;
		this.idPokedex = idPokedex;
		this.codiceAmico = codiceAmico;
	}
	
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
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
	public long getIdPokedex() {
		return idPokedex;
	}
	public void setIdPokedex(long idPokedex) {
		this.idPokedex = idPokedex;
	}
	public String getCodiceAmico() {
		return codiceAmico;
	}
	public void setCodiceAmico(String codiceAmico) {
		this.codiceAmico = codiceAmico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codiceAmico, genere, idPokedex, idUser, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(codiceAmico, other.codiceAmico) && genere == other.genere && idPokedex == other.idPokedex
				&& idUser == other.idUser && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", username=" + username + ", genere=" + genere + ", idPokedex=" + idPokedex
				+ ", codiceAmico=" + codiceAmico + "]";
	}
	
	public static User fromJSON(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);

		if(!jsonObject.has("idUser") || !jsonObject.has("username") || !jsonObject.has("genere") || !jsonObject.has("idPokedex") || !jsonObject.has("codiceAmico"))  
			throw new JSONException("Where are the idUser or username or genere or idPokedex or codiceAmico?");
		
		long idUser = jsonObject.getLong("idUser");
		String username = jsonObject.getString("username");
		boolean genere = jsonObject.getBoolean("genere");
		long idPokedex = jsonObject.getLong("idPokedex");
		String codiceAmico = jsonObject.getString("codiceAmico");

		return new User(idUser,username,genere,idPokedex,codiceAmico);
	}

	public String toJsonString() {
		return new JSONObject(this).toString();	
	}
}
