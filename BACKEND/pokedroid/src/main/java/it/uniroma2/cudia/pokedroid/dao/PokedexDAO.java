package it.uniroma2.cudia.pokedroid.dao;

import it.uniroma2.cudia.pokedroid.entity.Pokedex;

public interface PokedexDAO {
	
	public int createPokedex();
	public void closeConnection();
}
