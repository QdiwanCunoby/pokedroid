package it.uniroma2.cudia.pokedroid.entity;

import java.util.Objects;

import org.json.JSONException;
import org.json.JSONObject;

public class Pokemon {
	
	private long idPokemon;
	private int tipo;
	private int forza;
	private int grinta;
	private int fortuna;
	private int difesa;
	private int astuzia;
	private int resistenza;
	private int velocita;
	private String codiceAttivazione;
	
	public Pokemon(long idPokemon, int tipo, int forza, int grinta, int fortuna, int difesa, int astuzia,
			int resistenza, int velocita,String codiceAttivazione) {
		super();
		this.idPokemon = idPokemon;
		this.tipo = tipo;
		this.forza = forza;
		this.grinta = grinta;
		this.fortuna = fortuna;
		this.difesa = difesa;
		this.astuzia = astuzia;
		this.resistenza = resistenza;
		this.velocita = velocita;
		this.setCodiceAttivazione(codiceAttivazione);
	}
	
	public Pokemon() {}

	public long getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(long idPokemon) {
		this.idPokemon = idPokemon;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getForza() {
		return forza;
	}

	public void setForza(int forza) {
		this.forza = forza;
	}

	public int getGrinta() {
		return grinta;
	}

	public void setGrinta(int grinta) {
		this.grinta = grinta;
	}

	public int getFortuna() {
		return fortuna;
	}

	public void setFortuna(int fortuna) {
		this.fortuna = fortuna;
	}

	public int getDifesa() {
		return difesa;
	}

	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}

	public int getAstuzia() {
		return astuzia;
	}

	public void setAstuzia(int astuzia) {
		this.astuzia = astuzia;
	}

	public int getResistenza() {
		return resistenza;
	}

	public void setResistenza(int resistenza) {
		this.resistenza = resistenza;
	}

	public int getVelocita() {
		return velocita;
	}

	public void setVelocita(int velocita) {
		this.velocita = velocita;
	}
	
	public String getCodiceAttivazione() {
		return codiceAttivazione;
	}

	public void setCodiceAttivazione(String codiceAttivazione) {
		this.codiceAttivazione = codiceAttivazione;
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hash(astuzia, codiceAttivazione, difesa, fortuna, forza, grinta, idPokemon, resistenza, tipo,
				velocita);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return astuzia == other.astuzia && Objects.equals(codiceAttivazione, other.codiceAttivazione)
				&& difesa == other.difesa && fortuna == other.fortuna && forza == other.forza && grinta == other.grinta
				&& idPokemon == other.idPokemon && resistenza == other.resistenza && tipo == other.tipo
				&& velocita == other.velocita;
	}

	@Override
	public String toString() {
		return "Pokemon [idPokemon=" + idPokemon + ", tipo=" + tipo + ", forza=" + forza + ", grinta=" + grinta
				+ ", fortuna=" + fortuna + ", difesa=" + difesa + ", astuzia=" + astuzia + ", resistenza=" + resistenza
				+ ", velocita=" + velocita + ", codiceAttivazione=" + codiceAttivazione + "]";
	}

	public static Pokemon fromJSON(String jsonString) throws JSONException {
		JSONObject jsonObject = new JSONObject(jsonString);

		if(!jsonObject.has("idPokemon") || !jsonObject.has("tipo") || !jsonObject.has("forza") 
		   || !jsonObject.has("grinta") || !jsonObject.has("fortuna") || !jsonObject.has("difesa")
		   || !jsonObject.has("astuzia") || !jsonObject.has("resistenza") || !jsonObject.has("velocita")
		   || !jsonObject.has("codiceAttivazione"))  
			throw new JSONException("Where are the idTipo or tipo?");
		
		long idPokemon = jsonObject.getLong("idPokemon");
		int tipo = jsonObject.getInt("tipo");
		int forza = jsonObject.getInt("forza");
		int difesa = jsonObject.getInt("difesa");
		int grinta = jsonObject.getInt("grinta");
		int fortuna = jsonObject.getInt("difesa");
		int astuzia = jsonObject.getInt("astuzia");
		int resistenza = jsonObject.getInt("resistenza");
		int velocita = jsonObject.getInt("velocita");
		String codiceAttivazione = jsonObject.getString("codiceAttivazione");

		return new Pokemon(idPokemon,tipo,forza,grinta,fortuna,difesa,astuzia,
				resistenza,velocita,codiceAttivazione);
	}

	public String toJsonString() {
		return new JSONObject(this).toString();	
	}


}
