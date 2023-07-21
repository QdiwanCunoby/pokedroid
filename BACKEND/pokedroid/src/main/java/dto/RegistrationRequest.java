package dto;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

import it.uniroma2.cudia.pokedroid.entity.User;
import it.uniroma2.cudia.pokedroid.entity.Utente;

public class RegistrationRequest {
	
	private User user;
	private Utente utente;
	
	public RegistrationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegistrationRequest(User user,Utente utente) {
		super();
		this.user = user;
		this.utente = utente;
		// TODO Auto-generated constructor stub
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		utente = utente;
	}

	@Override
	public String toString() {
		return "RegistrationRequest [user=" + user + ", Utente=" + utente + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(utente, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationRequest other = (RegistrationRequest) obj;
		return Objects.equals(utente, other.utente) && Objects.equals(user, other.user);
	}
	
	public static RegistrationRequest fromJSON(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);

		if(!jsonObject.has("user") || !jsonObject.has("utente"))  
			throw new JSONException("Where are the user or utente ?");
		
		JSONObject UserJsonObject =  jsonObject.getJSONObject("user"); 
		
		long idUser	= UserJsonObject.getLong("idUser");
		String username = UserJsonObject.getString("username");
		boolean genere = UserJsonObject.getBoolean("genere");
		long idPokedex = UserJsonObject.getLong("idPokedex");
		String codiceAmico = UserJsonObject.getString("codiceAmico");
		
		User user = new User(idUser,username,genere,idPokedex,codiceAmico);
		
		JSONObject UtenteJsonObject =  jsonObject.getJSONObject("utente");
		
		long idUtente = UtenteJsonObject.getLong("idUtente");
		String email = UtenteJsonObject.getString("email");
		String password = UtenteJsonObject.getString("password");
		
		Utente utente =  new Utente(idUtente,email,password);
		
		return new RegistrationRequest(user,utente);
	}

	public String toJsonString() {
		return new JSONObject(this).toString();	
	}
}
