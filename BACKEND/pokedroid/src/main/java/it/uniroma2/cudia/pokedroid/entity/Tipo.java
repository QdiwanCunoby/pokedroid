package it.uniroma2.cudia.pokedroid.entity;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Tipo {

	private int idTipo;
	private String tipo;
	
	public Tipo(int idTipo, String tipo) {
		super();
		this.idTipo = idTipo;
		this.tipo = tipo;
	}
	
	public int getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTipo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipo other = (Tipo) obj;
		return idTipo == other.idTipo && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Tipo [idTipo=" + idTipo + ", tipo=" + tipo + "]";
	}
	
	public static Tipo fromJSON(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);

		if(!jsonObject.has("idTipo") || !jsonObject.has("tipo"))  
			throw new JSONException("Where are the idTipo or tipo?");
		
		int idTipo = jsonObject.getInt("idTipo");
		String tipo = jsonObject.getString("tipo");

		return new Tipo(idTipo,tipo);
	}

	public String toJsonString() {
		return new JSONObject(this).toString();	
	}
}
