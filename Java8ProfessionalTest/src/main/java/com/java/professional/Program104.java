package com.java.professional;

public class Program104 {

	public static void main(String[] args)throws Exception {
		
		Candidate c1 = new Candidate("James", 20);
		Candidate c2 = new Candidate("Williams", 32);
		
		System.out.println(c1);
		System.out.println(c2);
	}
}


class MissingInfoException extends Exception{}

class AgeOutOfRangeException extends Exception{}

class Candidate{
	String name;
	int age;

	public Candidate(String name, int age) throws Exception{
		if(null == name) {
			throw new MissingInfoException();
		}
		else if(age <= 10 || age >=150) {
			throw new AgeOutOfLimitException();
		}
		else {
			this.name = name;
			this.age = age;
		}
	}

	@Override
	public String toString() {
		return "Candidate [name=" + name + ", age=" + age + "]";
	}
	
}