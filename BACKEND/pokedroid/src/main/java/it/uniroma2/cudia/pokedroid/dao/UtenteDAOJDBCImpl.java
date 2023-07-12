package it.uniroma2.cudia.pokedroid.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.sql.Statement;

import it.uniroma2.cudia.pokedroid.entity.Utente;

public class UtenteDAOJDBCImpl implements UtenteDAO {
	
	private Connection conn;
	
	public UtenteDAOJDBCImpl(String ip, String port, String dbName, String userName, String pwd) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbName+"?&serverTimezone=UTC", userName, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int createUtente(Utente utente) {
		String SQL = "INSERT INTO utente(uten_mail,uten_password) " + "VALUES(?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, utente.getEmail());
			pstmt.setString(2, utente.getPassword());

			int affectedRows = pstmt.executeUpdate();

			return affectedRows;

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public int checkRegistrazioneUtenza(Utente utente) {
		String query = "SELECT COUNT(*) FROM utente WHERE uten_email = " + utente.getEmail() + " uten_password = " + utente.getPassword();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			int res = -1;
			if (rset.next())
				res = rset.getInt(1);

			rset.close();
			stmt.close();

			return res;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
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
