package com.java.professional;

public class Program17 {

	public static void main(String[] args) {

		Book b1 = new Book(1, "Java Program");
		Book b2 = new Book(2, "Java Program");
		
		System.out.println(b1.equals(b2));
	}

}

class Book{
	int id;
	String name;
	
	public Book(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public boolean equals(Object obj) {
		boolean output = false;
		Book b = (Book)obj;
		
		if(this.name.equals(b.name)) {
			output = true;
		}
		
		return output;
	}
}