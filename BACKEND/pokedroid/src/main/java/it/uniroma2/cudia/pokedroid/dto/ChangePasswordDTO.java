package it.uniroma2.cudia.pokedroid.dto;

import org.json.JSONException;
import org.json.JSONObject;

import it.uniroma2.cudia.pokedroid.entity.Utente;

public class ChangePasswordDTO {

	private String email;
	private String currentPassword;
	private String newPassword;
	
	public ChangePasswordDTO(String email,String currentPassword, String newPassword) {
		super();
		this.email = email;
		this.currentPassword = currentPassword;
		this.newPassword = newPassword;
	}
	
	public String getEmail() {
		return email;
	}

	public void setIdUtente(String email) {
		this.email = email;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public static ChangePasswordDTO fromJSON(String jsonString) throws JSONException {
		System.out.println(jsonString);
		JSONObject jsonObject = new JSONObject(jsonString);

		if(!jsonObject.has("currentPassword") || !jsonObject.has("newPassword") || !jsonObject.has("email"))
			throw new JSONException("Where are the newPassword or newPassword or email?");
		
		String email = jsonObject.getString("email");
		String currentPassword = jsonObject.getString("currentPassword");
		String newPassword = jsonObject.getString("newPassword");

		return new ChangePasswordDTO(email,currentPassword ,newPassword);
	}
	
	public String toJsonString() {
		return new JSONObject(this).toString();	
	}
}
