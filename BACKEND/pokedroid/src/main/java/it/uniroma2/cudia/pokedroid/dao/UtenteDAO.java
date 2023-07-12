package it.uniroma2.cudia.pokedroid.dao;

import it.uniroma2.cudia.pokedroid.entity.Utente;

public interface UtenteDAO {
	
	public int createUtente(Utente utente);
	
	public int checkRegistrazioneUtenza(Utente utente);
	
	public void closeConnection();

}
