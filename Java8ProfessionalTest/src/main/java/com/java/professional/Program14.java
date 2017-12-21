package com.java.professional;

public class Program14 {

	public static void main(String[] args) {

		Program14 p = new Program14();
		try {
			p.doStuff();
		}
		catch(ArithmeticException | NumberFormatException e) {
			System.out.println("Run -- "+e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Excp -- "+e.getMessage());
		}
		
	}

	void doStuff()throws ArithmeticException, NumberFormatException, Exception{
		if(Math.random() > -1 )
			throw new Exception("Try ASgain");
	}
}
