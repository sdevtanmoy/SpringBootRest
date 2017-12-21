package com.java.professional;

public class Program124 {

	public static String doMsg(char x) {
		return "Good Day!"+x;
	}
	
	public static String doMsg(int y) {
		return "Good Luck!"+y;
	}
	
	public static void main(String[] args) {
		char x = 8;
		int z = '8';
		
		System.out.println(doMsg(x));
		
		System.out.println(doMsg(z));
	}
}
