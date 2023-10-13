package it.uniroma2.cudia.pokedroid.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONException;

import it.uniroma2.cudia.pokedroid.dao.UserDAO;
import it.uniroma2.cudia.pokedroid.dao.UserDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.entity.User;
import it.uniroma2.cudia.pokedroid.entity.Utente;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = -6117027497998497053L;
	
	private UserDAO dao;

	public UserServlet() {
		super();
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
	
	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UserServlet. Invoking a doPost method...");
		try {
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
				response.setStatus(400);//BAD-REQUEST-CODE
				e.printStackTrace();
				return;
			}
			
			if( user.getUsername() == null || user.getCodiceAmico() == null || user.getIdPokedex() == 0 ) {
				response.setStatus(400);
				response.getWriter().append("username or codice amico or idPokedex are null");
				return;
			}
			
			try {
				if(dao.createUser(user) == null ) {
					response.getWriter().append("false");
				}
				else {
					response.getWriter().append("true");
				}
			} catch (SQLException e) {
				response.setStatus(499);//SQL-ERROR-CODE
				e.printStackTrace();
				return;
			} catch (IOException e) {
							}	
		} 
		catch(Exception e) {
			response.setStatus(500);//SERVER-STATUS-CODE
			e.printStackTrace();
			return;
 
		}
		
		return;
	}
	
	@Override
	public void destroy() {
		System.out.print("UserServlet. Closing DB connection...");
		dao.closeConnection();
		System.out.println("DONE.");
	}

}
