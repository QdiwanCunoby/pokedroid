package it.uniroma2.cudia.pokedroid.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import it.uniroma2.cudia.pokedroid.entity.ListaPokemon;
import it.uniroma2.cudia.pokedroid.entity.Pokemon;

public class PokemonDAOJDBCImpl implements PokemonDAO {
	
	private Connection conn;
	
	public PokemonDAOJDBCImpl(String ip, String port, String dbName, String userName, String pwd) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbName+"?&serverTimezone=UTC", userName, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ListaPokemon getListaPokemonSbloccati(String uten_mail, String uten_password) throws SQLException{
		String SQL_SELECT = "SELECT p.poke_id,p.poke_nome, p.poke_tipo, p.poke_forza, p.poke_grinta, p.poke_fortuna, p.poke_difesa, p.poke_astuzia, p.poke_resistenza, p.poke_velocita\r\n"
				+ "\r\n"
				+ "FROM pokemon AS p\r\n"
				+ "	INNER JOIN\r\n"
				+ "	avanzamento AS a\r\n"
				+ "	ON p.poke_id = a.pokemon_id\r\n"
				+ "\r\n"
				+ "WHERE a.pokedex_id = ( SELECT pk.poke_id \r\n"
				+ "\r\n"
				+ "		       FROM pokedex AS pk\r\n"
				+ "				INNER JOIN\r\n"
				+ "				user AS u\r\n"
				+ "				ON pk.poke_id = u.user_id_pokedex\r\n"
				+ "\r\n"
				+ "			   WHERE u.user_id = (SELECT u.user_id\r\n"
				+ "\r\n"
				+ "					  FROM user as u\r\n"
				+ "						  INNER JOIN\r\n"
				+ "					  	  utenza AS ut \r\n"
				+ "					  	  ON u.user_id = ut.user_id\r\n"
				+ "\r\n"
				+ "					  WHERE  ut.uten_id = ( SELECT utn.uten_id\r\n"
				+ "\r\n"
				+ "								FROM utente AS utn\r\n"
				+ "\r\n"
				+ "								WHERE utn.uten_mail = '"+uten_mail+"' AND utn.uten_password ='"+uten_password+"')))"
				+ "\r\n"
				+ "ORDER BY p.poke_id";
		
		ResultSet affectedRows = null;
		conn.setAutoCommit(false);
		ListaPokemon listaPokemon = new ListaPokemon();
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT);
			affectedRows = pstmt.executeQuery();
			

			while(affectedRows.next()) {
				listaPokemon.add(new Pokemon(affectedRows.getLong(1), affectedRows.getString(2), affectedRows.getInt(3), 
						affectedRows.getInt(4), affectedRows.getInt(5), affectedRows.getInt(6), affectedRows.getInt(7),
						affectedRows.getInt(8), affectedRows.getInt(9),affectedRows.getInt(10),null));
			}

		} catch (SQLException e) {
		
			conn.rollback();
			e.printStackTrace();
			return null;
		
		}
		
		conn.commit();
		return listaPokemon;
	}

	@Override
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			Enumeration<Driver> enumDrivers = DriverManager.getDrivers();
			while (enumDrivers.hasMoreElements()) {
				Driver driver = enumDrivers.nextElement();
				DriverManager.deregisterDriver(driver);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
