package it.uniroma2.cudia.pokedroid.entity;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Utenza {
	
	private long utenteId;
	private long userId;
	
	public Utenza(long utenteId, long userId) {
		super();
		this.utenteId = utenteId;
		this.userId = userId;
	}

	public long getUtenteId() {
		return utenteId;
	}

	public void setUtenteId(long utenteId) {
		this.utenteId = utenteId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, utenteId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utenza other = (Utenza) obj;
		return userId == other.userId && utenteId == other.utenteId;
	}

	@Override
	public String toString() {
		return "Utenza [utenteId=" + utenteId + ", userId=" + userId + "]";
	}

	public static Utenza fromJSON(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);

		if(!jsonObject.has("idUtente") || !jsonObject.has("idUser"))  
			throw new JSONException("Where are the idTipo or tipo?");
		
		long idUtente = jsonObject.getLong("idUtente");
		long idUser = jsonObject.getLong("idUser");

		return new Utenza(idUtente,idUser);
	}

	public String toJsonString() {
		return new JSONObject(this).toString();	
	}
}
