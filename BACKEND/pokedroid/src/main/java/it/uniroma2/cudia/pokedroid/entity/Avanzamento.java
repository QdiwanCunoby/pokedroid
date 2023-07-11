package it.uniroma2.cudia.pokedroid.entity;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Avanzamento {
	
	private long idPokemon;
	private long idPokedex;
	
	public Avanzamento(long idPokemon, long idPokedex) {
		super();
		this.idPokemon = idPokemon;
		this.idPokedex = idPokedex;
	}
	
	public Avanzamento() {}

	public long getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(long idPokemon) {
		this.idPokemon = idPokemon;
	}

	public long getIdPokedex() {
		return idPokedex;
	}

	public void setIdPokedex(long idPokedex) {
		this.idPokedex = idPokedex;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPokedex, idPokemon);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avanzamento other = (Avanzamento) obj;
		return idPokedex == other.idPokedex && idPokemon == other.idPokemon;
	}

	@Override
	public String toString() {
		return "Avanzamento [idPokemon=" + idPokemon + ", idPokedex=" + idPokedex + "]";
	}
	
	public static Avanzamento fromJSON(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);

		if(!jsonObject.has("idPokemon") || !jsonObject.has("idPokedex"))  
			throw new JSONException("Where are the idPokemon or idPokedex?");
		
		long idPokemon = jsonObject.getLong("idPokemon");
		long idPokedex = jsonObject.getLong("idPokedex");

		return new Avanzamento(idPokemon,idPokedex);
	}

	public String toJsonString() {
		return new JSONObject(this).toString();	
	}
}
