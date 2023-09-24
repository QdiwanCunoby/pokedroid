package it.uniroma2.cudia.pokedroid.dao;

import java.sql.SQLException;

import it.uniroma2.cudia.pokedroid.dto.ListaFriendDTO;

public interface AmiciziaDAO {
	int addFrindship(String usernameMandanteRichiesta,String usernameRiceventeRichiesta) throws SQLException;
	ListaFriendDTO getListaInfoFriend(String email) throws SQLException;
	void closeConnection();
}
