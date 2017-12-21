package com.java.professional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Program84 {

	public static void main(String[] args) {
		
		List<String> colors = Arrays.asList("red", "yellow", "green");
		
		Predicate<String> test = s -> {
			System.out.println("searching...");
			return s.contains("red");
		};
		
		colors.stream()
			.filter(c -> c.length() >3)
			.allMatch(test);
	}
}
