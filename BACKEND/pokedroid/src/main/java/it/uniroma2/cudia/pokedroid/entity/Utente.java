package it.uniroma2.cudia.pokedroid.entity;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Utente {
	
	private long idUtente;
	private String email;
	private String password;

	public Utente(long idUtente, String email, String password) {
		super();
		this.idUtente = idUtente;
		this.email = email;
		this.password = password;
	}
	
	public Utente() {}

	@Override
	public int hashCode() {
		return Objects.hash(email, idUtente, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		return Objects.equals(email, other.email) && idUtente == other.idUtente
				&& Objects.equals(password, other.password);
	}

	public long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
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

	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", email=" + email + ", password=" + password + "]";
	}
	
	public static Utente fromJSON(String jsonString) throws JSONException {
		System.out.println(jsonString);
		JSONObject jsonObject = new JSONObject(jsonString);

		if(!jsonObject.has("idUtente") || !jsonObject.has("email") || !jsonObject.has("password"))
			throw new JSONException("Where are the idUtente or email or password?");
		
		long idUtente = jsonObject.getLong("idUtente");
		String email = jsonObject.getString("email");
		String password = jsonObject.getString("password");

		return new Utente(idUtente,email ,password);
	}

	public String toJsonString() {
		return new JSONObject(this).toString();	
	}
}
