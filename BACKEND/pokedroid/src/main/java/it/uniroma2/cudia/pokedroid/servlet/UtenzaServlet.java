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

import dto.RegistrationRequest;
import it.uniroma2.cudia.pokedroid.dao.PokedexDAO;
import it.uniroma2.cudia.pokedroid.dao.PokedexDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UserDAO;
import it.uniroma2.cudia.pokedroid.dao.UserDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UtenteDAO;
import it.uniroma2.cudia.pokedroid.dao.UtenteDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UtenzaDAO;
import it.uniroma2.cudia.pokedroid.dao.UtenzaDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.entity.Utente;
import it.uniroma2.cudia.pokedroid.entity.Utenza;

public class UtenzaServlet extends HttpServlet {

	private static final long serialVersionUID = -5018132304356878712L;
	
	private UtenzaDAO daoUtenza;
	private UtenteDAO daoUtente;
	private UserDAO daoUser;
	private PokedexDAO daoPokedex;
	
	public UtenzaServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		String ip = getInitParameter("ip");
		String port = getInitParameter("port");
		String dbName = getInitParameter("dbName");
		String userName = getInitParameter("userName");
		String password = getInitParameter("password");

		System.out.print("UtenzaServlet. Opening DB connection...");
		
		daoUtenza = new UtenzaDAOJDBCImpl(ip,port,dbName,userName,password);
		daoUtente = new UtenteDAOJDBCImpl(ip,port,dbName,userName,password);
		daoPokedex = new PokedexDAOJDBCImpl(ip,port,dbName,userName,password);
		daoUser = new UserDAOJDBCImpl(ip,port,dbName,userName,password);
		
		System.out.println("DONE.");
	}
	
	@Override
	public void destroy() {
		System.out.print("UtenteServlet. Closing DB connection...");
		daoUtenza.closeConnection();
		System.out.println("DONE.");
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UtenteServlet. Invoking a doPost method.");
		
		PrintWriter out = response.getWriter();
		
		BufferedReader reader = request.getReader();
	    String line;
	    StringBuilder sb = new StringBuilder();
	    
	    while ((line = reader.readLine()) != null) {
		      sb.append(line);
		}
	    
	    String jsonDataRegistrationRequest =  sb.toString();
		
	    RegistrationRequest registrationRequest = null;
		
		try {
			registrationRequest = RegistrationRequest.fromJSON(jsonDataRegistrationRequest);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( registrationRequest.getUtente() == null || registrationRequest.getUser() == null ) {
			response.setStatus(404);
			response.getWriter().append("utente or user are null");
			return;
		}
		
		try {
			
			
			
			registrationRequest.getUser().setIdPokedex(daoPokedex.createPokedex());
			if(daoUtenza.createUtenza(new Utenza((long)(daoUtente.createUtente(registrationRequest.getUtente())),(long)(daoUser.createUser(registrationRequest.getUser())))) == -1) {
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
