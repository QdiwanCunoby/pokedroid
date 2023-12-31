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

import it.uniroma2.cudia.pokedroid.dao.PokedexDAO;
import it.uniroma2.cudia.pokedroid.dao.PokedexDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UserDAO;
import it.uniroma2.cudia.pokedroid.dao.UserDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UtenteDAO;
import it.uniroma2.cudia.pokedroid.dao.UtenteDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UtenzaDAO;
import it.uniroma2.cudia.pokedroid.dao.UtenzaDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dto.ProspettoUtenteDTO;
import it.uniroma2.cudia.pokedroid.dto.RegistrationRequest;
import it.uniroma2.cudia.pokedroid.entity.User;
import it.uniroma2.cudia.pokedroid.entity.Utente;
import it.uniroma2.cudia.pokedroid.entity.Utenza;
import it.uniroma2.cudia.pokedroid.entity.Pokedex;

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
		try {
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
				response.setStatus(400);// BAD-REQUEST-CODE
				e.printStackTrace();
				return;
			}
			
			if( registrationRequest.getUtente() == null || registrationRequest.getUser() == null ) {
				response.setStatus(400);// BAD-REQUEST-CODE
				response.getWriter().append("utente or user are null");
				return;
			}
			
			try {	
				Pokedex pokedex = new Pokedex(daoPokedex.createPokedex(),0);
				registrationRequest.getUser().setIdPokedex(pokedex.getIdPokedex());
				User user = daoUser.createUser(registrationRequest.getUser());
				Utente utente = daoUtente.createUtente(registrationRequest.getUtente());
				
				if(daoUtenza.createUtenza(new Utenza(utente.getIdUtente(),user.getIdUser())) == -1) {
					response.getWriter().append("false");
				}
				else {
					ProspettoUtenteDTO prospettoUtente = new ProspettoUtenteDTO(user,utente,pokedex);
					response.getWriter().append(prospettoUtente.toJsonString());
				}
			} catch (SQLException e) {
				response.setStatus(599);//SQL-ERROR-CODE
				e.printStackTrace();
				return;
			} catch (IOException e) {
				response.setStatus(500);//SERVER-STATUS-CODE
				e.printStackTrace();
				return;
			}
		}
		catch(Exception e) {
			response.setStatus(500);//SERVER-STATUS-CODE
			e.printStackTrace();
			return;
		}
		return;
	}

}
