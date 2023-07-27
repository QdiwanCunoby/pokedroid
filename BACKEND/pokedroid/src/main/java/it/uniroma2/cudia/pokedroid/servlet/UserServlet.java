package it.uniroma2.cudia.pokedroid.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import it.uniroma2.cudia.pokedroid.dao.UserDAO;
import it.uniroma2.cudia.pokedroid.dao.UserDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.entity.User;
import it.uniroma2.cudia.pokedroid.entity.Utente;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = -6117027497998497053L;
	
	private UserDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		String ip = getInitParameter("ip");
		String port = getInitParameter("port");
		String dbName = getInitParameter("dbName");
		String userName = getInitParameter("userName");
		String password = getInitParameter("password");

		System.out.print("UserServlet. Opening DB connection...");

		dao = new UserDAOJDBCImpl(ip, port, dbName, userName, password);

		System.out.println("DONE.");
	}

	@Override
	public void destroy() {
		System.out.print("UserServlet. Closing DB connection...");
		dao.closeConnection();
		System.out.println("DONE.");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MusicianServlet. Invoking a doPost method...");

		PrintWriter out = response.getWriter();
		
		BufferedReader reader = request.getReader();
	    String line;
	    StringBuilder sb = new StringBuilder();
	    
	    while ((line = reader.readLine()) != null) {
		      sb.append(line);
		}
	    
	    String jsonDataUtente =  sb.toString();

		User user = null;
		
		try {
			user = User.fromJSON(jsonDataUtente);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( user.getUsername() == null || user.getCodiceAmico() == null || user.getIdPokedex() == 0 ) {
			response.setStatus(404);
			response.getWriter().append("username or codice amico or idPokedex are null");
			return;
		}
		
		try {
			if(dao.createUser(user) != 1) {
				response.getWriter().append("false");
			}
			else {
				response.getWriter().append("true");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}

}
