package com.java.professional;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Program33 {

	public static void main(String[] args) {
		int i;
		char c;
		try(FileInputStream fis = new FileInputStream("/Users/tanmoydas/Java-Work/courses.txt");
				InputStreamReader isr = new InputStreamReader(fis);){
			while(isr.ready()) { // n1
				isr.skip(2);
				i = isr.read();
				c = (char)i;
				System.out.print(c);
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

