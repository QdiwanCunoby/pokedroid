package it.uniroma2.cudia.pokedroid.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import it.uniroma2.cudia.pokedroid.entity.User;

public class UserDAOJDBCImpl implements UserDAO {
	
	private Connection conn;
	
	public UserDAOJDBCImpl(String ip, String port, String dbName, String userName, String pwd) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbName+"?&serverTimezone=UTC", userName, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public User createUser(User user) throws SQLException {
		String SQL_INSERT = "INSERT INTO user(user_username,user_genere,user_id_pokedex,user_codice_amico) " + "VALUES(?,?,?,?)";
		String SQL_TAKE_ID = "SELECT LAST_INSERT_ID()";
		int affectedRows = 0;
		ResultSet resultSetId = null;
		conn.setAutoCommit(false);
		
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, user.getUsername());
			pstmt.setBoolean(2, user.isGenere());
			pstmt.setLong(3, user.getIdPokedex());
			pstmt.setString(4, user.getCodiceAmico());
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
			System.out.println("last id in user table insert is : " + resultSetId.getInt(1));
			return new User((long)resultSetId.getInt(1),user.getUsername(),user.isGenere(),user.getIdPokedex(),user.getCodiceAmico());
		}

		return null;
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
