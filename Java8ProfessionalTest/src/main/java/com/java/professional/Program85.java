package com.java.professional;

public class Program85 {

	public void doRegister(String name, int age) 
			throws UserException, AgeOutOfLimitException{
		 
		if(name.length()<6) {
			throw new UserException();
		}
		else if(age >= 60) {
			throw new AgeOutOfLimitException();
		}
		else {
			System.out.println("User is registered.");
		}
	}
	
	public static void main(String[] args) throws UserException, AgeOutOfLimitException {
		Program85 t = new Program85();
		t.doRegister("Mathew", 50);
	}
}


class UserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2378093227104366832L;}

class AgeOutOfLimitException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8078812374964988312L;}