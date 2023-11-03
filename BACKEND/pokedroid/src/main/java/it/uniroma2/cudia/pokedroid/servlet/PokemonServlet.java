package it.uniroma2.cudia.pokedroid.servlet;
import jakarta.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import it.uniroma2.cudia.pokedroid.dao.AvanzamentoDAO;
import it.uniroma2.cudia.pokedroid.dao.AvanzamentoDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.PokedexDAO;
import it.uniroma2.cudia.pokedroid.dao.PokedexDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.PokemonDAO;
import it.uniroma2.cudia.pokedroid.dao.PokemonDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UserDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UtenteDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UtenzaDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dto.RegistrationRequest;
import it.uniroma2.cudia.pokedroid.entity.ListaPokemon;

public class PokemonServlet extends HttpServlet {

	private static final long serialVersionUID = 2935400352059799743L;
	
	private PokemonDAO daoPokemon;
	private PokedexDAO daoPokedex;
	private AvanzamentoDAO daoAvanzamento;
	
	public PokemonServlet() {
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
		System.out.print("PokemonServlet. Opening DB connection...");
		
		daoPokemon = new PokemonDAOJDBCImpl(ip,port,dbName,userName,password);
		daoPokedex = new PokedexDAOJDBCImpl(ip,port,dbName,userName,password);
		daoAvanzamento = new AvanzamentoDAOJDBCImpl(ip,port,dbName,userName,password);
		
		System.out.println("DONE.");
	}
	
	@Override
	public void destroy() {
		System.out.print("UtenteServlet. Closing DB connection...");
		daoPokemon.closeConnection();
		System.out.println("DONE.");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("PokemonServlet. Invoking a doGet method.");
		
		PrintWriter out = response.getWriter();
		
		ListaPokemon listaPokemon = null;
		
		try {
			listaPokemon = daoPokemon.getListaPokemonSbloccati(request.getParameter("email"), request.getParameter("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(listaPokemon==null) {
			response.getWriter().append("");
			return;
		}
		
		
		out.append(listaPokemon.toJSONString());
		
		return;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("PokemonServlet. Invoking a doPost method.");
		PrintWriter out = response.getWriter();
		long idPokemon = 0;
		JSONObject jsonObject = null;
		double avanzamento = 0;
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { /*report an error*/ }

		  try {
			System.out.println(jb.toString());
		    jsonObject = new  JSONObject(jb.toString());
			System.out.println(jb.toString());
			System.out.println(jsonObject);
		    idPokemon = daoPokemon.checkCodiceRiscattoPokemon(jsonObject.getString("codice"));
			System.out.println(jb.toString());
			if(idPokemon != 0) {
				if(daoPokemon.riscattaPokemon(idPokemon,jsonObject.getInt("idPokedex"))==-1) {;
					System.out.println(jb.toString());
					out.print("{ esito: 'already inserted' }");
					return;
				}
			}
		  } catch (JSONException e) {
		    // crash and burn
		    throw new IOException("Error parsing JSON request string");
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(idPokemon != 0) {
			
			//out.print("{ esito: 'true' }");
			try {
				daoPokedex.updateAvanzamentoPokedex(jsonObject.getInt("idPokedex"));
				avanzamento = daoAvanzamento.countPokemon(jsonObject.getInt("idPokedex"));
			} catch (JSONException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String s = "{ esito: 'true', avanzamento:"+(int) avanzamento+" }";
			out.print(s);
			return;
		}
		out.print("{ esito: 'false' }");
		return;
	}

}
