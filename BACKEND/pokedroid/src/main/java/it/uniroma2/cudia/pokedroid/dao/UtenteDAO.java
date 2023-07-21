package it.uniroma2.cudia.pokedroid.dao;

import java.sql.SQLException;

import it.uniroma2.cudia.pokedroid.entity.Utente;

public interface UtenteDAO {
	
	public int createUtente(Utente utente) throws SQLException;
	
	public int checkRegistrazioneUtenza(Utente utente);
	
	public void closeConnection();

}
