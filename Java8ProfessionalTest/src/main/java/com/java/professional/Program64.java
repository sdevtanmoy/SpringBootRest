package com.java.professional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program64 {

	public static void main(String[] args) {
		
		List<Empl> li = Arrays.asList(
				new Empl("Sam", 20),
				new Empl("John", 60),
				new Empl("Jim", 51)
				);
		
		Predicate<Empl> agVal = e -> e.geteAge()>50; // n1
		System.out.println(li.size());
		li = li.stream().filter(agVal).collect(Collectors.toList());
		System.out.println(li.size());
		
		Stream<String> names = li.stream().map(Empl::geteName); //n2
		
		names.forEach(n -> System.out.print(n+" "));
	}
}


class Empl{
	private String eName;
	private Integer eAge;
	public Empl(String eName, Integer eAge) {
		this.eName = eName;
		this.eAge = eAge;
	}
	public String geteName() {
		return eName;
	}
	public Integer geteAge() {
		return eAge;
	}
	
}