package com.java.professional;

import java.util.function.Supplier;

public class Program7 {

	public static void main(String[] args) {

		tffly(() -> new Bird()); 
		tffly(Penguin :: new);
	}

	
	private static void tffly(Supplier<Bird> bird) {

		bird.get().fly();
	}

}

class Bird{
	public void fly() {
		System.out.println("Can Fly");
	}
}

class Penguin extends Bird{
	public void fly() {
		System.out.println("Can not Fly");
	}
}