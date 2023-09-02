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
	public Utente createUtente(Utente utente) throws SQLException {
		String SQL_INSERT = "INSERT INTO utente(uten_mail,uten_password) " + "VALUES(?,?)";
		String SQL_TAKE_ID = "SELECT LAST_INSERT_ID()";
		int affectedRows = 0;
		ResultSet resultSetId = null;
		conn.setAutoCommit(false);

		try {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, utente.getEmail());
			pstmt.setString(2, utente.getPassword());
			affectedRows = pstmt.executeUpdate();

		} catch (SQLException e) {
		
			conn.rollback();
			e.printStackTrace();
			return null;
		
		}
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_TAKE_ID);
			resultSetId = pstmt.executeQuery();

		} catch (SQLException e) {

			conn.rollback();
			e.printStackTrace();
			return null;
		
		}
		
		conn.commit();
		
		if(resultSetId.next()) {
			System.out.println("last id in utente table insert is : " + resultSetId.getInt(1));
			return  new Utente(resultSetId.getInt(1),utente.getEmail(),utente.getPassword());
		}

		return null;
	}

	@Override
	public int checkRegistrazioneUtenza(String email, String password) {
		String query = "SELECT * FROM utente WHERE uten_mail = '" + email + "' AND uten_password = '" + password +"'";
		System.out.println(query);

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
