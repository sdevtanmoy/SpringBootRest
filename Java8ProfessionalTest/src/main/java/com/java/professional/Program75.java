package com.java.professional;

import java.util.Arrays;

public class Program75 {

	public static void main(String[] args) {
		
		String [] strArray = new String[] {"Tiger", "Rat", "Cat", "Lion"}; 
		//n1
		Arrays.sort(strArray, CheckClass::checkValue);
		
		for(String str : strArray) {
			System.out.print(str+" ");
		}
		
	}
}


class CheckClass{
	public static int checkValue(String s1, String s2) {
		return s1.length() - s2.length();
	}
}