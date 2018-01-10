package com.quisqo.ZeeslagGame;

import java.util.Scanner;
import java.util.*;



public class Zeeslag {
	
	public static void main (String[] args) {
		Schip schip = new Schip();
		int [] locaties = {2, 3, 4};
		schip.setLocaties(locaties);
		String spelersSchot = "1";
		schip.testSchot(spelersSchot);
		
	}
		
		
}
