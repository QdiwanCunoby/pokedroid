package it.uniroma2.cudia.pokedroid.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import it.uniroma2.cudia.pokedroid.dao.UtenteDAO;
import it.uniroma2.cudia.pokedroid.dao.UtenteDAOJDBCImpl;

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
}
