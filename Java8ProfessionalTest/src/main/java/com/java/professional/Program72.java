package com.java.professional;

public class Program72 {

	public static void main(String[] args) {
		int rateOfInterest = 0;
		String accountType= "LOAN";
		
		switch(accountType) {
		
		case "RD":
			rateOfInterest = 5;
			break;
		case "FD":
			rateOfInterest = 10;
			break;
		default:
			assert false:"No Interest for this account"; // n1
		}
		
		System.out.println(rateOfInterest);
	}
}
