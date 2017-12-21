package com.java.professional;

import java.util.Arrays;
import java.util.List;

public class Program42 {

	public static void main(String[] args) {
		List<String> empDetails = 
				Arrays.asList("100, Robin, HR", "200, Mary, Admin", "101, Peter, HR");
		
		empDetails.stream()
			.filter(s -> s.contains("1"))
			.sorted()
			.forEach(System.out::println);
	}
}
