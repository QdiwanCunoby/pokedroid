package it.uniroma2.cudia.pokedroid.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import it.uniroma2.cudia.pokedroid.dto.ListaFriendDTO;

public class AmiciziaDAOJDBCImpl  implements AmiciziaDAO {
	
	private Connection conn;
	
	public AmiciziaDAOJDBCImpl(String ip, String port, String dbName, String userName, String pwd) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dbName+"?&serverTimezone=UTC", userName, pwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int addFrindship(String usernameMandanteRichiesta, String usernameRiceventeRichiesta) throws SQLException {
		
		int stateUpdate = 0;
		
		String SQL_SELECT = "SELECT u.user_id FROM `user` AS u WHERE u.user_username='"+ usernameMandanteRichiesta +"' OR u.user_username='"+ usernameRiceventeRichiesta+"'";
		
		conn.setAutoCommit(false);
		
		ArrayList<Double> idUsername = new ArrayList<Double>();
		
		try {
			ResultSet affectedRows = null;
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT);
			affectedRows = pstmt.executeQuery();
			
			while(affectedRows.next()) {
				idUsername.add(affectedRows.getDouble(1));
			}
			
			String SQL_INSERT = " INSERT INTO amicizia\r\n"
					+ "VALUES ('" + idUsername.get(0) + "','" + idUsername.get(1) + "')";
			pstmt = conn.prepareStatement(SQL_INSERT);
			stateUpdate = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			conn.rollback();
			e.printStackTrace();
			return -1;
		}	
	
	
		conn.commit();
		
		return stateUpdate;
		
	}
	
	@Override
	public ListaFriendDTO getListaInfoFriend(String username) throws SQLException {
	
		String SQL_SELECT = "SELECT u.user_id FROM `user` AS u WHERE u.user_username ='"+ username +"'";
		ListaFriendDTO listaFriendDTO = new ListaFriendDTO(new ArrayList<ListaFriendDTO.InfoFriend>()); 
		conn.setAutoCommit(false);
		try {
			ResultSet affectedRows = null;
			
			PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT);
			affectedRows = pstmt.executeQuery();
			
			if(affectedRows.next()) {
				double id = affectedRows.getDouble(1);
				SQL_SELECT = "SELECT u.user_username, p.poke_completamento\r\n"
						+ "FROM amicizia AS a \r\n"
						+ "JOIN `user` AS u ON a.user_id_2=u.user_id\r\n"
						+ "JOIN pokedex AS p ON u.user_id_pokedex=p.poke_id\r\n"
						+ " WHERE a.user_id_1 ='"+ id +"'";
				affectedRows = pstmt.executeQuery(SQL_SELECT);
				while(affectedRows.next()) {
					listaFriendDTO.getInfoFriendList().add(new ListaFriendDTO.InfoFriend(affectedRows.getString(1),affectedRows.getDouble(2)));
				}
				
				SQL_SELECT = "SELECT u.user_username, p.poke_completamento"
						+ " FROM amicizia AS a "
						+ " JOIN `user` AS u ON a.user_id_1=u.user_id"
						+ " JOIN pokedex AS p ON u.user_id_pokedex=p.poke_id"
						+ " WHERE a.user_id_2 ='"+ id +"'";
				affectedRows = pstmt.executeQuery(SQL_SELECT);
				while(affectedRows.next()) {
					listaFriendDTO.getInfoFriendList().add(new ListaFriendDTO.InfoFriend(affectedRows.getString(1),affectedRows.getDouble(2)));
				}
			}
			
		} catch (SQLException e) {
			
			conn.rollback();
			e.printStackTrace();
			return null;
		}	
		
		conn.setAutoCommit(false);
		
		return listaFriendDTO;
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
