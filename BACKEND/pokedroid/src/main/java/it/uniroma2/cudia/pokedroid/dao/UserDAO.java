package it.uniroma2.cudia.pokedroid.dao;

import java.sql.SQLException;

import it.uniroma2.cudia.pokedroid.entity.User;

public interface UserDAO {
	
	public User createUser(User utente) throws SQLException;
	public void closeConnection();
}
