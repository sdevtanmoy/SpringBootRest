package com.java.professional;

public class Program113 {

	public static void main(String[] args) {
		DoInterface doi = new DoClass();
		doi.m1(100);
		doi.m2(200);
	}
}

interface DoInterface{
	void m1(int n); //n1
	public void m2(int n);
}

class DoClass implements DoInterface{
	int x1, x2;
	
	DoClass(){
		this.x1 = 0;
		this.x2 = 10;
	}

	@Override
	public void m1(int p1) {
		x1 += p1; System.out.println(x1);  // n2
		
	}

	@Override
	public void m2(int p1) {
		x2 += p1; System.out.println(x2);
		
	}
	
	
}
