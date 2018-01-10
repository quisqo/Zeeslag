package com.quisqo.ZeeslagGame;

import java.util.Scanner;
import java.util.*;



public class Zeeslag {
	
	public static void main (String[] args) {
		Scanner input = new Scanner (System.in);
		Schip schip = new Schip();
		String spelersSchot;
		int aantalSchoten = 0;
		boolean schipDrijftNog = true;
		int [] locaties = {2, 3, 4};
		schip.setLocaties(locaties);
		
		while (schipDrijftNog) {
			String resultaat;
			System.out.println(" Doe een schot");
			spelersSchot = input.nextLine();
			resultaat = schip.testSchot(spelersSchot);
			aantalSchoten++;
			if(resultaat.equals("Zink")) {
				schipDrijftNog = false;
			}
		}
		
		System.out.println(" Je hebt " + aantalSchoten + " schoten nodig gehad om het schip te laten zinken ");
		
	}
		
		
}
