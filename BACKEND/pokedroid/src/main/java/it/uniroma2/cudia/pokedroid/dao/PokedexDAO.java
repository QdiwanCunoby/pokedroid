package it.uniroma2.cudia.pokedroid.dao;

import java.sql.SQLException;

import it.uniroma2.cudia.pokedroid.entity.Pokedex;

public interface PokedexDAO {
	
	public int createPokedex() throws SQLException;
	public double getAvanzamento(int idPokedex) throws SQLException;
	public int updateAvanzamentoPokedex(int idPokedex) throws SQLException;
	public void closeConnection();
}
