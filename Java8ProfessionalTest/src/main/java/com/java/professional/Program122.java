package com.java.professional;

public class Program122 {

	public static void main(String[] args) {
		
	}
}

abstract class Shape2{
	private int x;
	private int y;
	
	public abstract void draw();
	
	public void setAnchar(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

abstract class Circle extends Shape2{}