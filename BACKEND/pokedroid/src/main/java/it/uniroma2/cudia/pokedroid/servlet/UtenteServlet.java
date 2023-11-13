package it.uniroma2.cudia.pokedroid.servlet;

import org.json.JSONObject;
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
import it.uniroma2.cudia.pokedroid.dto.ChangePasswordDTO;
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
				response.setStatus(401);//NO-AUTHENTICATE
				JSONObject jsonObject = new JSONObject();

		        // Put key-value pairs into the JSON object
		        jsonObject.put("login", true);
		        
		        // Convert the JSON object to a JSON string
		        String jsonString = jsonObject.toString();
				out.write(jsonString);
			}
		} catch(Exception e) {
			response.setStatus(500);//SERVER-STATUS-CODE
			e.printStackTrace();
			return;
		}
		
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("UtenteServlet. Invoking a doPut method.");
		
		PrintWriter out = response.getWriter();
		
		BufferedReader reader = request.getReader();
	    String line;
	    StringBuilder sb = new StringBuilder();
	    
	    while ((line = reader.readLine()) != null) {
		      sb.append(line);
		}
	    
	    String jsonDataUtente =  sb.toString();
		
	    ChangePasswordDTO changePasswordDTO = null;
		
		try {
			changePasswordDTO = ChangePasswordDTO.fromJSON(jsonDataUtente);
		} catch (JSONException e) {
			response.setStatus(500);//SERVER-STATUS-CODE
			e.printStackTrace();
		}
		
		try {
			dao.checkUserPassword(changePasswordDTO.getEmail(), changePasswordDTO.getCurrentPassword());
		} catch (SQLException e) {
			response.setStatus(499);//SQL-ERROR-CODE
			e.printStackTrace();
			return;
		}
		try {
			dao.changeUserPassword(changePasswordDTO.getEmail(), changePasswordDTO.getCurrentPassword(), changePasswordDTO.getNewPassword());
		} catch (SQLException e) {
			response.setStatus(499);//SQL-ERROR-CODE
			e.printStackTrace();
			return;
		}
		
		out.append("{ 'passwordUpdate' : true }");
        response.setStatus(200);
	}
	
	@Override
	public void destroy() {
		System.out.print("UtenteServlet. Closing DB connection...");
		dao.closeConnection();
		System.out.println("DONE.");
	}
	
}
