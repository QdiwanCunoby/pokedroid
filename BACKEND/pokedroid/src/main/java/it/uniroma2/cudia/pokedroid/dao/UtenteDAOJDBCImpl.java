package it.uniroma2.cudia.pokedroid.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.sql.Statement;

import it.uniroma2.cudia.pokedroid.dto.ProspettoUtenteDTO;
import it.uniroma2.cudia.pokedroid.entity.Pokedex;
import it.uniroma2.cudia.pokedroid.entity.User;
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
	public ProspettoUtenteDTO checkRegistrazioneUtenza(String email, String password) {
		String query = "SELECT * FROM utente WHERE uten_mail = '" + email + "' AND uten_password = '" + password +"'";
		System.out.println(query);

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query);

			ProspettoUtenteDTO prospettoUtente = null;
			if (rset.next()) {
				
				String SEARCH_USER = "SELECT us.user_username, us.user_genere, us.user_id_pokedex, us.user_codice_amico, p.poke_completamento\r\n"
						+ "	FROM utente AS ut JOIN utenza AS u  ON ut.uten_id = u.uten_id \r\n"
						+ "		JOIN `user` AS us ON u.user_id = us.user_id\r\n"
						+ "		JOIN pokedex AS p ON p.poke_id = us.user_id_pokedex\r\n"
						+ "		WHERE (ut.uten_mail ='"+ email + "' AND ut.uten_password = '"+password+"')";
				
				rset = stmt.executeQuery(SEARCH_USER);
				
				if (rset.next()) {
					System.out.println(rset.getString(1));
					
					prospettoUtente =  new ProspettoUtenteDTO(
							new User(0,rset.getString(1),rset.getBoolean(2),rset.getLong(3),rset.getString(4))
							, new Utente(email,password)
							, new Pokedex(rset.getLong(3),rset.getInt(5)));
				}
			}
				
			rset.close();
			stmt.close();
			System.out.println(prospettoUtente);
			return prospettoUtente;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
