package com.java.professional;

public class Program78 {

}

interface Doable {
	public void doSomething(String s);
}

abstract class Task implements Doable {
	public void doSomething(String s) {

	}
}

abstract class Work implements Doable {
	public abstract void doSomething(String s);

	public void doYourThing(Boolean b) {
	}
}

class Job implements Doable {
	public void doSomething(Integer i) {

	}

	public void doSomething(String s) {

	}
}

class Do implements Doable{
	public void doSomething(String s) {

	}
	
	public void doSomething(Integer i) {

	}
	public void doThat(String s) {
		
	}
}