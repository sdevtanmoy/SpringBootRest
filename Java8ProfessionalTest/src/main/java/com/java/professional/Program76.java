package com.java.professional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program76 {

	public static void main(String[] args) {
		List<TechName> techs = Arrays.asList(
				new TechName("Java-"),
				new TechName("Oracle DB-"),
				new TechName("J2EE-")
				);
		
		Stream<TechName> stre = techs.stream();
		//n1
		stre.map(a ->a.techName).forEach(System.out::print);
	}

}

class TechName{
	String techName;
	
	public TechName(String techName) {this.techName = techName;}

}