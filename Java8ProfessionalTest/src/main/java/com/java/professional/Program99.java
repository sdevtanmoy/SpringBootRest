package com.java.professional;

public class Program99 {

	public static void main(String[] args) {
		Caller2 c = new Caller2();
		c.start();
		//c.init();
	}
}

class Caller2{
	
	private void init() {
		System.out.println("initialized");
	}
	
	public void start() {
		init();
		System.out.println("started");
	}
}