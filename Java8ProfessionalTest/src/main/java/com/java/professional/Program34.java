package com.java.professional;

public class Program34<T> {

	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		Program34<String> type = new Program34<>();
		
		Program34 type1 = new Program34();
		type.set("Java");
		type1.set(100);
		
		System.out.println(type.get()+" -- "+type1.get());
	}
}
