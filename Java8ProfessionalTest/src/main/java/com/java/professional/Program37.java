package com.java.professional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program37 {

	public static void main(String[] args) {

		List<Book2> books = Arrays.asList(
				new Book2("Beginning with Java", 2),
				new Book2("A guide to Java Tour", 3)
				);
		
		Collections.sort(books, new Book2());
		
		System.out.println(books);
	}

}


class Book2 implements Comparator<Book2>{
	String name;
	double price;
	public Book2(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public Book2() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compare(Book2 b1, Book2 b2) {
		return b1.name.compareTo(b2.name);
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", price=" + price + "]";
	}
	
	
}