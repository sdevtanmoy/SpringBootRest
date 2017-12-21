package com.java.professional;

public class Program63 {

	public static void main(String[] args) throws FuleNotAvailableException, Exception{
		
		Vehicle3 v = new SolarVehicle();
		v.ride();
	}
}

class FuleNotAvailableException extends Exception{}

class Vehicle3{
	protected void ride()throws Exception{ // n1
		System.out.println("Happy Journey.");
	}
}

class SolarVehicle extends Vehicle3{
	public void ride()throws Exception{
		super.ride();
	}
}