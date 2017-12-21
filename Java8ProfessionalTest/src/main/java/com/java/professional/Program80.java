package com.java.professional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program80 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader brCopy = null;
		try(BufferedReader br = new BufferedReader(
				new FileReader("/Users/tanmoydas/Java-Work/ocpjp-test/yello.txt"))){ // n1
			System.out.println("n1");
			br.lines().forEach(c -> System.out.println(c));
			System.out.println("n2");
			brCopy = br; 		//n2
		}
		System.out.println("n3");
		brCopy.ready(); //n3
	}
}
