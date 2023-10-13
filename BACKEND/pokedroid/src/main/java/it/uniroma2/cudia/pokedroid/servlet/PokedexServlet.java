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
import it.uniroma2.cudia.pokedroid.entity.Pokedex;
import it.uniroma2.cudia.pokedroid.entity.User;

public class PokedexServlet extends HttpServlet {

	private static final long serialVersionUID = 134313364478166973L;
	
	private PokedexDAO dao;

	public PokedexServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		String ip = getInitParameter("ip");
		String port = getInitParameter("port");
		String dbName = getInitParameter("dbName");
		String userName = getInitParameter("userName");
		String password = getInitParameter("password");

		System.out.print("PokedexServlet. Opening DB connection...");

		dao = new PokedexDAOJDBCImpl(ip, port, dbName, userName, password);

		System.out.println("DONE.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PokedexServlet. Invoking a doPost method...");

		PrintWriter out = response.getWriter();
		
		try{
			if(dao.createPokedex() == -1) {	
				response.getWriter().append("false");
			}
			else {
				response.getWriter().append("true");
			}
		}catch (SQLException  e) {
			response.setStatus(599);//SQL-ERROR-CODE 
			e.printStackTrace();
		}catch ( IOException e) {
			response.setStatus(500);//SERVER-ERROR-CODE
			e.printStackTrace();
		}
		
		return;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PokedexServlet. Invoking a doGet method...");
		try {
			if(request.getParameter("pokedex")==null ) {
				response.setStatus(400);//BAD-REQUEST-CODE
				return;
			}
			
			PrintWriter out = response.getWriter();
			double avanzamento=0;
			
			try {
				avanzamento=dao.getAvanzamento(Integer.valueOf(request.getParameter("pokedex")));
			} catch (NumberFormatException e) {
				response.setStatus(400);//BAD-REQUEST-CODE
				e.printStackTrace();
				return;
			} catch (SQLException e) {
				response.setStatus(599);//SQL-ERROR-CODE
				e.printStackTrace();
				return;
			}  
			
			String jsonString = "{avanzamento:"+(int)avanzamento+"}";
			
			out.write(jsonString);
		} 
		catch(Exception e) {
			response.setStatus(500);//SERVER-ERROR-CODE
			e.printStackTrace();
		}
		
		return;
	}
	
	@Override
	public void destroy() {
		System.out.print("PokedexServlet. Closing DB connection...");
		dao.closeConnection();
		System.out.println("DONE.");
	}

}
