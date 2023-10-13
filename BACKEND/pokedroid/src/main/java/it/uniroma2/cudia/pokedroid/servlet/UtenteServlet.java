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

import it.uniroma2.cudia.pokedroid.dao.UtenteDAO;
import it.uniroma2.cudia.pokedroid.dao.UtenteDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dto.ProspettoUtenteDTO;
import it.uniroma2.cudia.pokedroid.entity.Utente;

public class UtenteServlet extends HttpServlet {

	private static final long serialVersionUID = -8011568261742744674L;

	private UtenteDAO dao;

	public UtenteServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		String ip = getInitParameter("ip");
		String port = getInitParameter("port");
		String dbName = getInitParameter("dbName");
		String userName = getInitParameter("userName");
		String password = getInitParameter("password");

		System.out.print("UtenteServlet. Opening DB connection...");
		
		dao = new UtenteDAOJDBCImpl(ip,port,dbName,userName,password);
		
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
	    
	    String jsonDataUtente =  sb.toString();
		
		Utente utente = null;
		
		try {
			utente = Utente.fromJSON(jsonDataUtente);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( utente.getEmail() == null || utente.getEmail() == null ) {
			response.setStatus(400);
			response.getWriter().append("password or email are null");
			return;
		}
		
		try {
			if(dao.createUtente(utente) == null) {
				response.getWriter().append("false");
			}
			else {
				response.getWriter().append("true");
			}
		} catch (SQLException e) {
			response.setStatus(499);//SQL-ERROR-CODE
			e.printStackTrace();
		} catch (IOException e) {
			response.setStatus(500);//SERVER-STATUS-CODE
			e.printStackTrace();
		}
		
		return;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UtenteServlet. Invoking a doGet method.");
		
		if(request.getParameter("email")==null || request.getParameter("password")==null){
			response.setStatus(400);//BAD-REQUEST-CODE
			return;
		}
		
		try {
			PrintWriter out = response.getWriter();
			ProspettoUtenteDTO prospettoUtente = dao.checkRegistrazioneUtenza(request.getParameter("email"),request.getParameter("password"));
			if( prospettoUtente != null) {
				response.getWriter().append(prospettoUtente.toJsonString());
			}
			else {
				response.getWriter().append(null);
			}
		} catch(Exception e) {
			response.setStatus(500);//SERVER-STATUS-CODE
			e.printStackTrace();
			return;
		}
		
	}
	
	@Override
	public void destroy() {
		System.out.print("UtenteServlet. Closing DB connection...");
		dao.closeConnection();
		System.out.println("DONE.");
	}
	
}
