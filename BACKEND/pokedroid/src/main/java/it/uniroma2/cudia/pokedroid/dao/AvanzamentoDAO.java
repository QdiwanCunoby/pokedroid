package it.uniroma2.cudia.pokedroid.dao;

import java.sql.SQLException;

public interface AvanzamentoDAO {
	
	public int countPokemon(long pokedexId) throws SQLException;

	public void closeConnection();

}
