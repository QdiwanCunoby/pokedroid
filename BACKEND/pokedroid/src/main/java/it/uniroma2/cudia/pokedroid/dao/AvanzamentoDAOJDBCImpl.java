package it.uniroma2.cudia.pokedroid.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

public class AvanzamentoDAOJDBCImpl implements  AvanzamentoDAO{
	
private Connection conn;
	
	public AvanzamentoDAOJDBCImpl(String ip, String port, String dbName, String userName, String pwd) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbName+"?&serverTimezone=UTC", userName, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public int countPokemon(long pokedexId) throws SQLException {
		
		String SQL_COUNT = "SELECT COUNT(*) FROM avanzamento AS a WHERE a.pokedex_id = "+pokedexId;
		conn.setAutoCommit(false);
		int numeroPokemon = -1;
		
		try {
			ResultSet affectedRows = null;
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_COUNT);
			affectedRows = pstmt.executeQuery();
			
			if(affectedRows.next()) {
				numeroPokemon = affectedRows.getInt(1);
			}
		} catch (SQLException e) {
			
			conn.rollback();
			e.printStackTrace();
			return -1;
		}	
	
	
		conn.commit();
		return numeroPokemon;
	}

	
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
