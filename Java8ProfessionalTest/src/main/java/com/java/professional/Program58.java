package com.java.professional;

import java.util.function.ToIntFunction;

public class Program58 {

	public static void main(String[] args) {
		String str = "Java is a programming language";
		
		ToIntFunction<String> indexVal = str::indexOf;//n1
		int x = indexVal.applyAsInt("Java"); //n2
		
		System.out.println(x);
		
		System.out.println(str.indexOf("l"));
	}
}
