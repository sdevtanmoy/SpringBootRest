package com.java.professional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Program60 {

	public static void main(String[] args) {
		List<String> nL = Arrays.asList("Jim", "John", "Jeff");
		
		Function<String, String> funVal = s -> "Hello : ".concat(s);
		nL.stream()
			.map(funVal)
			.peek(System.out::println);
		
		System.out.println("Done");
	}
}
