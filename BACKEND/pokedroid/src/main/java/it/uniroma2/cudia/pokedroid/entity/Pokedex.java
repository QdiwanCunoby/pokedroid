package it.uniroma2.cudia.pokedroid.entity;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Pokedex {
	
	private long idPokedex;
	private int completamento;
	
	public Pokedex(long idPokedex, int completamento) {
		super();
		this.idPokedex = idPokedex;
		this.completamento = completamento;
	}
	
	public Pokedex() {}

	public long getIdPokedex() {
		return idPokedex;
	}
	public void setIdPokedex(long idPokedex) {
		this.idPokedex = idPokedex;
	}
	public int getCompletamento() {
		return completamento;
	}
	public void setCompletamento(int completamento) {
		this.completamento = completamento;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(completamento, idPokedex);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokedex other = (Pokedex) obj;
		return completamento == other.completamento && idPokedex == other.idPokedex;
	}

	@Override
	public String toString() {
		return "Pokedex [idPokedex=" + idPokedex + ", completamento=" + completamento + "]";
	}
	
	public static Pokedex fromJSON(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);

		if(!jsonObject.has("idPokedex") || !jsonObject.has("completamento"))
			throw new JSONException("Where are the idPokedex or completamento?");
		
		long idPokedex = jsonObject.getLong("idPokedex");
		int completamento = jsonObject.getInt("completamento");

		return new Pokedex(idPokedex,completamento);
	}

	public String toJsonString() {
		return new JSONObject(this).toString();	
	}
}
