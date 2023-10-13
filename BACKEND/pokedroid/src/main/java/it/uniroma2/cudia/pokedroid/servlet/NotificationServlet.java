package it.uniroma2.cudia.pokedroid.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.json.JSONObject;


public class NotificationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1203037409163758769L;
	
	public NotificationServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		String ip = getInitParameter("ip");
		String port = getInitParameter("port");
		String dbName = getInitParameter("dbName");
		String userName = getInitParameter("userName");
		String password = getInitParameter("password");

		System.out.print("NotificationServlet. Opening Firebase connection...");
		
		FirebaseOptions options = null;
		FileInputStream serviceAccount = null;
		
		try {
			System.out.println("Working Directory = " + System.getProperty("user.dir"));
			serviceAccount =
					new FileInputStream("D:\\Radice\\Learn\\universita\\triennale\\dasostenere\\android\\PROGETTOESAME\\BACKEND\\pokedroid\\conf-service\\pokedroid-b4317-firebase-adminsdk-26z7i-c46a975d52.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			options = new FirebaseOptions.Builder()
					  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
					  .build();
		} catch (IOException e) {
			e.printStackTrace();
		}

			FirebaseApp.initializeApp(options);
		
		System.out.println("DONE.");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("PokedexServlet. Invoking a doPost method...");

		PrintWriter out = response.getWriter();
		String token = null;
		String username = null;
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  

		
			System.out.println(jb.toString());
		    JSONObject jsonObject = new  JSONObject(jb.toString());
			System.out.println(jb.toString());
			System.out.println(jsonObject);
			token = jsonObject.getString("token");
			username = jsonObject.getString("username");
			System.out.println(jb.toString());
		  
		
		Message message = Message.builder()
			    .putData("username", username)
			    .setToken(token)
			    .build();

			// Send a message to the device corresponding to the provided
			// registration token.
			String responseFirebase = null;
			try {
				responseFirebase = FirebaseMessaging.getInstance().send(message);
			} catch (FirebaseMessagingException e) {
				e.getStackTrace();
				response.setStatus(598);//ERROR-FIREBASE-CODE
				return;
			}
			// Response is a message ID string.
			System.out.println("Successfully sent message: " + responseFirebase);
		  } catch (Exception e) { 
			  e.getStackTrace();
			  response.setStatus(500);//ERROR-SERVER-CODE
		  }
			return;
		
	}
	
	@Override
	public void destroy() {
		System.out.print("NotificationServlet. Closing Firebase connection...");
		System.out.println("DONE.");
	}
}
