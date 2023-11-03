package it.uniroma2.cudia.pokedroid.servlet;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import it.uniroma2.cudia.pokedroid.dao.AvanzamentoDAO;
import it.uniroma2.cudia.pokedroid.dao.AvanzamentoDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.PokemonDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.entity.ListaPokemon;

public class AvanzamentoServlet extends HttpServlet {


	private static final long serialVersionUID = 7069917022423216035L;
	
	private AvanzamentoDAO daoAvanzamento;
	
	public AvanzamentoServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		String ip = context.getInitParameter("ip");
		String port = context.getInitParameter("port");
		String dbName = context.getInitParameter("dbName");
		String userName = context.getInitParameter("userName");
		String password = context.getInitParameter("password");
		System.out.print("AvanzamentoServlet. Opening DB connection...");
		
		daoAvanzamento = new AvanzamentoDAOJDBCImpl(ip,port,dbName,userName,password);
		
		System.out.println("DONE.");
	}
	
	@Override
	public void destroy() {
		System.out.print("AvanzamentoServlet. Closing DB connection...");
		daoAvanzamento.closeConnection();
		System.out.println("DONE.");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("PokemonServlet. Invoking a doGet method.");
		
		PrintWriter out = response.getWriter();
		
		int numeroPokemon = -1;
		Long idPokedex = new Long((request.getParameter("pokedex")));
	
		try {
			
			numeroPokemon = daoAvanzamento.countPokemon(idPokedex.longValue());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(numeroPokemon==-1) {
			response.getWriter().write(""+-1);
			return;
		}
		
		
		response.getWriter().write(""+numeroPokemon);
		
		return;
	}
}
