package it.uniroma2.cudia.pokedroid.dao;

import java.sql.SQLException;

import it.uniroma2.cudia.pokedroid.entity.ListaPokemon;

public interface PokemonDAO {
	
	public ListaPokemon getListaPokemonSbloccati( String uten_mail, String uten_password ) throws SQLException;
	
	public void closeConnection(); 
	
	public void riscattaPokemon(long pokemon_id,long pokedex_id) throws SQLException;
}
