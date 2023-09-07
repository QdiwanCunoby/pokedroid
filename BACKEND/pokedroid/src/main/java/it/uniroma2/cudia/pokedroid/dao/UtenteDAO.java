package it.uniroma2.cudia.pokedroid.dao;

import java.sql.SQLException;

import it.uniroma2.cudia.pokedroid.dto.ProspettoUtenteDTO;
import it.uniroma2.cudia.pokedroid.entity.User;
import it.uniroma2.cudia.pokedroid.entity.Utente;

public interface UtenteDAO {
	
	public Utente createUtente(Utente utente) throws SQLException;
	
	public ProspettoUtenteDTO checkRegistrazioneUtenza(String email, String password);
	
	public void closeConnection();

}
