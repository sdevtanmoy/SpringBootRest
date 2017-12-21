package com.java.professional;

public class Program81 {

	public static void main(String[] args) {
		Book1 b1 = new Book1();
		//b1.read("");
		
		EBook b2 = new EBook();
		b2.read("URL....");
	}
}

class Book1{
	private String read(String bname) {return "Read "+ bname;}
}

class EBook extends Book1{
	public String read(String url) {return "view "+url;}
}