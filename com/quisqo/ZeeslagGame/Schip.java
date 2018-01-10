package com.quisqo.ZeeslagGame;

public class Schip {
	private int [] locatie;
	private int aantalSchoten;
	
	public void setLocaties (int [] loc) {
		locatie = loc;
	}
	
	public String testSchot (String spelersSchot) {
		String resultaat = "mis";
		
		int schot = Integer.parseInt(spelersSchot);
		
		for (int loc : locatie) {
			
			if (schot == loc) {
				
				aantalSchoten++;
				
				resultaat = aantalSchoten == locatie.length ? "Zink" : "Raak";
				break;
			}
		}
		
		System.out.println(resultaat);
		
		return resultaat;
	}
}