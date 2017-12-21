package com.java.professional;

public class Program109 {

	public static void main(String[] args) {
		XX xref = new YY();
		YY yref = (YY) xref;
		
		yref.mY();
		xref.mX();
	}
}

class XX{
	public void mX() {
		System.out.println("Xm1");
	}
}

class YY extends XX{
	public void mX() {
		System.out.println("Xm2");
	}
	public void mY() {
		System.out.println("Ym");
	}
}