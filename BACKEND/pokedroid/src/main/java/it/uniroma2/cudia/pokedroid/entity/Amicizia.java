package it.uniroma2.cudia.pokedroid.entity;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Amicizia {
	
	private long idUser1;
	private long idUser2;
	
	public Amicizia(){}
	
	public Amicizia(long idUser1, long idUser2) {
		super();
		this.idUser1 = idUser1;
		this.idUser2 = idUser2;
	}
	
	public long getIdUser1() {
		return idUser1;
	}
	public void setIdUser1(long idUser1) {
		this.idUser1 = idUser1;
	}
	public long getIdUser2() {
		return idUser2;
	}
	public void setIdUser2(long idUser2) {
		this.idUser2 = idUser2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUser1, idUser2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amicizia other = (Amicizia) obj;
		return idUser1 == other.idUser1 && idUser2 == other.idUser2;
	}

	@Override
	public String toString() {
		return "Amicizia [idUser1=" + idUser1 + ", idUser2=" + idUser2 + "]";
	}
	
	public static Amicizia fromJSON(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);

		if(!jsonObject.has("idUser1") || !jsonObject.has("idUser2"))  
			throw new JSONException("Where are the idUser1 or idUser2?");
		
		long idUser1 = jsonObject.getLong("idUser1");
		long idUser2 = jsonObject.getLong("idUser2");

		return new Amicizia(idUser1,idUser2);
	}

	public String toJsonString() {
		return new JSONObject(this).toString();	
	}
}
