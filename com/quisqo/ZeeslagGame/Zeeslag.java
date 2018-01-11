package com.quisqo.ZeeslagGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Zeeslag {
	private ArrayList<Schip> schip = new ArrayList<Schip>();
	int aantalSchoten = 0;

	public static void main(String[] args) {
		Zeeslag zeeslag = new Zeeslag();
		zeeslag.setUp();
	}

	private void setUp() {
		schip.add(new Schip("Mijnenjager", 3));
		schip.add(new Schip("Kruiser", 3));
		schip.add(new Schip("Onderzeeboot", 3));
		setLocatie();

		System.out.println(" Welkom bij Zeeslag");
		System.out.println(" Laat de schepen zo snel mogelijk zinken, bombs away!!");
		play();

	}

	private void play() {
		String schot, resultaat;
		Scanner input = new Scanner(System.in);
		while (!schip.isEmpty()) {
			resultaat = " Mis, haha. ";
			aantalSchoten++;
			System.out.println(" Schiet maar! ");
			schot = input.nextLine();
			schot = schot.toUpperCase();
			for (int i = 0; i < schip.size(); i++) {
				resultaat = (schip.get(i).check(schot));
				if (resultaat.equals(" Blublub ")) {
					resultaat = (" Je hebt " + schip.get(i).getName()+ " laten zinken ");
					schip.remove(i);
					break;
				} else if (resultaat.equals(" Raak ")) {
					break;
				}
			}
			System.out.println(resultaat);
		}

		input.close();
		finish();

	}

	private void finish() {
		if (aantalSchoten == 9) {
			System.out.println(" Fantastisch gedaan, een perfect score. ");
		} else if (aantalSchoten < 20) {
			System.out.println(" Goed gedaan! Je hebt er " + aantalSchoten + " voor nodig gehad. ");
		} else if (aantalSchoten < 30) {
			System.out.println(" Netjes gedaan! Je hebt er " + aantalSchoten + " voor nodig gehad. ");
		} else {
			System.out.println(" Je kan er niks van! Je hebt er " + aantalSchoten + " voor nodig gehad. ");

		}
	}

	private void setLocatie() {
		Random rand = new Random();
		ArrayList<String> locatieToSet = new ArrayList<String>();
		ArrayList<String> temp = null;
		int let, num, incl, incn;
		String alpha = "ABCDEFG";
		boolean worked;
		for (int i = 0; i < schip.size(); i++) {
			worked = false;
			start: while (!worked) {
				locatieToSet.clear();
				worked = true;
				let = rand.nextInt(5);
				num = 1 + rand.nextInt(5);
				// Hier wordt bepaald of het schip horizontaal of verticaal ligt
				if (num % 2 == 0) {
					incl = 1; // verticaal
					incn = 0;
				} else {
					incl = 0;
					incn = 1; // horizontaal
				} // sluit if
				for (int j = 0; j < schip.get(i).getSize(); j++) {
					String loc = "" + alpha.charAt(let) + num;
					let += incl;
					num += incn;

					for (int t = 0; t < schip.size(); t++) {
						if (t != i) {
							temp = schip.get(t).getLocatie();
							if (temp.contains(loc)) {
								worked = false;
								continue start; // gefaald, begin opnieuw
							}
						} // sluit de if
					} // sluit de for loop van t we hier komen zijn we if voorbij
					locatieToSet.add(loc);
				} // sluit de for loop van je
				schip.get(i).setLocatie(locatieToSet);
			} // sluit de while loop
		} // sluit de i for loop
	}// sluit de locatie to set
}// sluit de class.
