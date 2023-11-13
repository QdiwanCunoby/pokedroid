package it.uniroma2.cudia.pokedroid.dao;

import java.sql.SQLException;

import it.uniroma2.cudia.pokedroid.dto.ProspettoUtenteDTO;
import it.uniroma2.cudia.pokedroid.entity.User;
import it.uniroma2.cudia.pokedroid.entity.Utente;

public interface UtenteDAO {
	
	public Utente createUtente(Utente utente) throws SQLException;
	
	public ProspettoUtenteDTO checkRegistrazioneUtenza(String email, String password);
	
	public boolean checkUserPassword(String email,String password) throws SQLException;
	public boolean changeUserPassword(String email,String password, String newPassword) throws SQLException;
	
	public void closeConnection();

}
