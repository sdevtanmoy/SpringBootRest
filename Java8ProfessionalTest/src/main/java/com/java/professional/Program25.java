package com.java.professional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Program25 {

	public static void main(String[] args) {
		
		List<String> strs = Arrays.asList("Java", "Java EE", "Java ME");
		
		Predicate<String> cf1 = s -> s.length() >3;
		
		Predicate cf2 = new CourseFilter() {
			public boolean test(String s) {
				return s.contains("Java");
			}
		};
		
		long c = strs.stream()
					.filter(cf1)
					.filter(cf2)
					.count();
		
		System.out.println(c);
	}
}

interface CourseFilter extends Predicate<String>{
	
	public default boolean test(String str) {
		return str.equals("Java");
	}
}