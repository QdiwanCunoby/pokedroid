package it.uniroma2.cudia.pokedroid.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.json.JSONException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import it.uniroma2.cudia.pokedroid.dao.AmiciziaDAO;
import it.uniroma2.cudia.pokedroid.dao.AmiciziaDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dto.ListaFriendDTO;


public class AmiciziaServlet extends HttpServlet {

	private static final long serialVersionUID = 7503037488163758769L;
	
	private AmiciziaDAO dao;
	
	public AmiciziaServlet() {
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

		dao = new AmiciziaDAOJDBCImpl(ip, port, dbName, userName, password);

		System.out.println("DONE.");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		ListaFriendDTO listaFriendDTO = null;
		
		try {
			listaFriendDTO = dao.getListaInfoFriend(request.getParameter("username"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.write(listaFriendDTO.toJsonString());
		
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AmiciziaServlet. Invoking a doPost method.");
		
		PrintWriter out = response.getWriter();
		
		BufferedReader reader = request.getReader();
	    String line;
	    StringBuilder sb = new StringBuilder();
	    
	    while ((line = reader.readLine()) != null) {
		      sb.append(line);
		}
	    
	    JSONObject jsonDataFriendship = new JSONObject(sb.toString());
		
		try {
			if(dao.addFrindship(jsonDataFriendship.getString("mandante"), jsonDataFriendship.getString("ricevente")) == 1) {
				out.write("accept friendship");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return;
	}
	

	@Override
	public void destroy() {
		System.out.print("AmiciziaServlet. Closing DB connection...");
		dao.closeConnection();
		System.out.println("DONE.");
	}
	
}
