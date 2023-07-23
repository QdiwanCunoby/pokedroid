package it.uniroma2.cudia.pokedroid.dao;

import java.sql.SQLException;

import it.uniroma2.cudia.pokedroid.entity.Utenza;

public interface UtenzaDAO {

	public int createUtenza(Utenza utenza) throws SQLException;
	public int checkUtenza(Utenza utenza) throws SQLException;

	public void closeConnection();

}
