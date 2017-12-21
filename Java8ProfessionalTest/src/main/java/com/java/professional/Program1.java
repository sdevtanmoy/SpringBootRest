/**
 * 
 */
package com.java.professional;

/**
 * @author tanmoydas
 *
 */
public class Program1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Vehicle v = new Vehicle(100);

		v.increSpeed(60);
	}

}

class Vehicle{
	int distance; // line n1
	
	Vehicle(int x){
		this.distance = x;
	}
	
	public void increSpeed(int time) { // line 2
		int timeTravel = time;		// line 3
		class Car{
			int value = 0;
			public void speed() {
				value = distance / timeTravel;
				System.out.println("Velocity with new Speed - "+value+" kmph");
			}
		}
		new Car().speed();
	}
}