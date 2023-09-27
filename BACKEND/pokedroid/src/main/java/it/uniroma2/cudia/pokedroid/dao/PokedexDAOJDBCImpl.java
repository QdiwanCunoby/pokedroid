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
	
	public double getAvanzamento(int idPokedex) throws SQLException {
		
		String SQL_SELECT = "SELECT poke_completamento FROM pokedex WHERE poke_id="+idPokedex;
		ResultSet affectedRows = null;
		conn.setAutoCommit(false);
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT);
			affectedRows = pstmt.executeQuery();
			
			if(affectedRows.next()) {
				double avanzamento = affectedRows.getDouble(1);
				conn.commit();
				return avanzamento;
			}
			
		} catch (SQLException e) {
		
			conn.rollback();
			e.printStackTrace();
			return -1;
		
		}
		return 0;
	}
	
	public int updateAvanzamentoPokedex(int idPokedex) throws SQLException {
		conn.setAutoCommit(false);
		String SQL_UPDATE ="UPDATE pokedex SET poke_completamento = "
				+ "(SELECT COUNT(*) FROM avanzamento AS a WHERE a.pokedex_id = "+ idPokedex +") "
				+ "WHERE poke_id = " + idPokedex;
		
		int affectedRows;
		ResultSet affectedRows2;
		PreparedStatement pstmt = conn.prepareStatement(SQL_UPDATE);
		String SQL_COUNT = "SELECT COUNT(*) FROM avanzamento AS a WHERE a.pokedex_id = "+idPokedex;
		
		int numeroPokemon = -1;
		
		
		try {	
			
			affectedRows = pstmt.executeUpdate();
			conn.commit();
			
			pstmt = conn.prepareStatement(SQL_COUNT);
			affectedRows2 = pstmt.executeQuery();
			
			if(affectedRows2.next()) {
				numeroPokemon = affectedRows2.getInt(1);
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
