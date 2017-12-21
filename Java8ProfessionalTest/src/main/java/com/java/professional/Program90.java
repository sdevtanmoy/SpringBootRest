package com.java.professional;

public class Program90 {

	public static void main(String[] args) {
		AnotherProgram90 ap = new AnotherProgram90();
		Program90 p = new Program90();
		p = ap;
		
		System.out.println("p -"+p.getClass());
		System.out.println("ap -"+ap.getClass());
		
		String message = "Hi everyone!";
		
		System.out.println("Message = "+message.replace("e", "x"));
	}
}

class AnotherProgram90 extends Program90{
	
}