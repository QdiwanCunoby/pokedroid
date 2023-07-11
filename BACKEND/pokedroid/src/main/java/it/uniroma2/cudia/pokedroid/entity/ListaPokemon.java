package it.uniroma2.cudia.pokedroid.entity;

import java.util.ArrayList;

import org.json.JSONArray;

public class ListaPokemon extends ArrayList<Pokemon> {
	
	private static final long serialVersionUID = 5013166673637496567L;

	public String toJSONString() {
		return new JSONArray(this).toString();
	}

}
