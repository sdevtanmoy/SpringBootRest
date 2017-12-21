package com.java.professional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exam37 {

	public static void main(String[] args) throws IOException{

		BufferedReader brCopy = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader("/Users/tanmoydas/Java-Work/ocpjp-test/yello.txt"))){
			
			br.lines().forEach(c -> System.out.println(c));
			brCopy = br;
			
		}
		brCopy.ready();
	}

}
