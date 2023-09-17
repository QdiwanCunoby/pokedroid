package it.uniroma2.cudia.pokedroid.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.auth.oauth2.GoogleCredentials;

import it.uniroma2.cudia.pokedroid.dao.PokedexDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UserDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UtenteDAOJDBCImpl;
import it.uniroma2.cudia.pokedroid.dao.UtenzaDAOJDBCImpl;

public class AmiciziaServlet extends HttpServlet {

	private static final long serialVersionUID = 7503037488163758769L;
	
	public AmiciziaServlet() {
		super();
	}
	
}
