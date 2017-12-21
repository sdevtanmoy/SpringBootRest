package com.java.professional;

public class Program100 {

	public static void main(String[] args) {
		Y myY = new Y();
		X myX = myY;
		Z myZ = myX;
		
		System.out.println(myX);
		System.out.println((Y)myX);
		System.out.println(myZ);
	}
}

interface Z{
	
}

class X implements Z{

	@Override
	public String toString() {
		return "X ";
	}
	
}

class Y extends X{
	@Override
	public String toString() {
		return "Y ";
	}
}