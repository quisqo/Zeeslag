package com.quisqo.ZeeslagGame;

import java.util.ArrayList;

public class Schip {
	private ArrayList<String> locatie = new ArrayList<String>();
	private String name;
	private int size;
	
	public Schip (String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	public ArrayList<String>getLocatie(){
		return locatie;
	}
	public int getSize() {
		return size;
	}
	public void setLocatie(ArrayList<String>locatieToSet) {
		this.locatie.addAll(locatieToSet);
	}
	
	
	public String check (String schot) {
		String resultaat = "mis";
		if (locatie.contains(schot)){
			locatie.remove(schot);
			resultaat = locatie.isEmpty() ? "Zink" : "Raak";
		}

		return resultaat;
		
			}
	public String getName() {
		return name;
		}

}