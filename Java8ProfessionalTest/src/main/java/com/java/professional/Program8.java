package com.java.professional;

public class Program8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

abstract class Shape{
	
	Shape(){
		System.out.println("Shape");
	}
	
	protected void area() {
		System.out.println("Shape..");
	}
}

class Square extends Shape{
	int side;
	
	Square(int side){
		/* insert code here */
		
		this.side = side;
	}
	
	public void area() {
		System.out.println("Square");
	}
}

class Rectangle extends Square{

	int len, br;
	
	Rectangle(int x, int y) {
		// code here 
		super(10);
		this.len = x; br = y;
		
	}
	
	public void area() {
		System.out.println("Recatangle");
	}
}