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

import it.uniroma2.cudia.pokedroid.dao.PokedexDAO;
import it.uniroma2.cudia.pokedroid.dao.PokedexDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.entity.Pokedex;
import it.uniroma2.cudia.pokedroid.entity.User;

public class PokedexServlet extends HttpServlet {

	private static final long serialVersionUID = 134313364478166973L;
	
	private PokedexDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PokedexServlet() {
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

		dao = new PokedexDAOJDBCImpl(ip, port, dbName, userName, password);

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
		System.out.println("PokedexServlet. Invoking a doPost method...");

		PrintWriter out = response.getWriter();
		
		
		try {
			if(dao.createPokedex() == -1) {
				
				response.getWriter().append("false");
			}
			else {
				response.getWriter().append("true");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}

}
