package it.uniroma2.cudia.pokedroid.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import it.uniroma2.cudia.pokedroid.entity.Pokedex;

public class PokedexDAOJDBCImpl implements PokedexDAO {
	
	private Connection conn;
	
	public PokedexDAOJDBCImpl(String ip, String port, String dbName, String userName, String pwd) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbName+"?&serverTimezone=UTC", userName, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int createPokedex() throws SQLException {
		String SQL_INSERT = "INSERT INTO pokedex(poke_completamento) " + "VALUES(0)";
		int affectedRows;
		ResultSet resultSetId = null;
		conn.setAutoCommit(false);
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
			affectedRows = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
		
			conn.rollback();
			e.printStackTrace();
			return -1;
		
		}
		
		try {
			
			String SQL_TAKE_ID = "SELECT LAST_INSERT_ID()";
			PreparedStatement pstmt = conn.prepareStatement(SQL_TAKE_ID);
			resultSetId = pstmt.executeQuery();
		
		}
		catch (SQLException e){
			
			conn.rollback();
			e.printStackTrace();
			return -1;
			
		}
		
		conn.commit();
		
		if(resultSetId.next()) {
			System.out.println("last id in pokedex table insert is : " + resultSetId.getInt(1));
			return resultSetId.getInt(1);
		}
		
		return -1;
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
