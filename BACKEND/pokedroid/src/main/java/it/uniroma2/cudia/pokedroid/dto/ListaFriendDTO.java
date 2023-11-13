package it.uniroma2.cudia.pokedroid.dto;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import it.uniroma2.cudia.pokedroid.entity.Utente;

public class ListaFriendDTO {
	
	ArrayList<InfoFriend> infoFriendList;
	
	public ListaFriendDTO(ArrayList<InfoFriend> infoFriendList) {
		super();
		this.infoFriendList = infoFriendList;
	}

	public ArrayList<InfoFriend> getInfoFriendList() {
		return infoFriendList;
	}

	public void setInfoFriendList(ArrayList<InfoFriend> infoFriendList) {
		this.infoFriendList = infoFriendList;
	}

	public static class InfoFriend {
		
		private String username;
		private double completamentoPokedex;
		
		public InfoFriend(String username, double completamentoPokedex) {
			super();
			this.username = username;
			this.completamentoPokedex = completamentoPokedex;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public double getCompletamentoPokedex() {
			return completamentoPokedex;
		}
		public void setCompletamentoPokedex(double completametoPokedex) {
			this.completamentoPokedex = completametoPokedex;
		}		
	}
	
	
	
	public String toJsonString() {
		return new JSONObject(this).toString();	
	}
}

