package com.java.professional;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Program18 {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/tanmoydas/Java-Work/Message.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("welcome1"));
		System.out.println(prop.getProperty("welcome2", "test")); // n1
		System.out.println(prop.getProperty("welcome3"));
	}
}
