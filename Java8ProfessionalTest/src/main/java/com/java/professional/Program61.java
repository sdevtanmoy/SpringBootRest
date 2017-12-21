package com.java.professional;

public class Program61 {

	public static void main(String[] args) {

		//A.
		Moveable<Integer> animal = s->System.out.println("Running .."+s);
		animal.run(100);
		animal.walk(20);
		//B.
		//Moveable animal2 = (Integer n)->System.out.println(n);;
		
	}
}

interface Moveable<Integer> {
	public default void walk(Integer distance) {
		System.out.println("walking... " + distance);
	}
	
	public void run(Integer distance);
}
