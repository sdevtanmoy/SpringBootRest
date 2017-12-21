package com.java.professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program22 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter GDP-");
		
		int gdp = Integer.parseInt(br.readLine());
		System.out.println(gdp);
		System.out.println(br.read());

	}

}
