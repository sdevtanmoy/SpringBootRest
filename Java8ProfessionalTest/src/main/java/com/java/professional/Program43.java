package com.java.professional;

public class Program43 {

	public static void main(String[] args) {
		
		//1.
		//Car auto = Car("MyCar")::new;
		
		//2. 
		//Car auto = Car::new;
		
		//Car vehicle = auto::getCar("MyCar");
		
		//3. 
		Rideable rider = Car::new;
		Car vehicle = rider.getCar("Mycar");
		
		//4. 
		//Car vehicle2 = Rideable::new::getCar("Mycar");
	}
}

interface Rideable{
	Car getCar(String name);
}
class Car{
	private String name;
	
	public Car(String name) {
		this.name = name;
	}
}
