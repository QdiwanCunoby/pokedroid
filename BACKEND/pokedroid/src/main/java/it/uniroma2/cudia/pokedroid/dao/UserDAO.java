package it.uniroma2.cudia.pokedroid.dao;

import it.uniroma2.cudia.pokedroid.entity.User;

public interface UserDAO {
	
	public int createUser(User utente);
	public void closeConnection();
}
