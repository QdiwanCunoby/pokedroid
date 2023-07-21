package it.uniroma2.cudia.pokedroid.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;

import it.uniroma2.cudia.pokedroid.entity.Utenza;

public class UtenzaDAOJDBCImpl implements UtenzaDAO {
	
private Connection conn;
	
	public UtenzaDAOJDBCImpl(String ip, String port, String dbName, String userName, String pwd) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbName+"?&serverTimezone=UTC", userName, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int createUtenza(Utenza utenza) throws SQLException {
		String SQL_INSERT = "INSERT INTO utenza(uten_id,user_id) " + "VALUES(?,?)";
		int affectedRows = 0;
		conn.setAutoCommit(false);
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setLong(1, utenza.getUtenteId());
			pstmt.setLong(2, utenza.getUserId());
			affectedRows = pstmt.executeUpdate();

		} catch (SQLException e) {
		
			conn.rollback();
			e.printStackTrace();
			return -1;
		
		}
		
		conn.commit();
	
		return affectedRows;
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
