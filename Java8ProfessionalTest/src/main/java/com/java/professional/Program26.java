package com.java.professional;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program26 {

	public static void main(String[] args) {

		List<Emp> empl = Arrays.asList(
				new Emp("John", "Smith"),
				new Emp("Peter", "Sam"),
				new Emp("Thomas", "Wale")
				);
		
		List<Emp> empl2 = empl.stream()
			.sorted(Comparator.comparing(Emp::getfName).reversed().thenComparing(Emp::getlName))
			.collect(Collectors.toList());
		
		System.out.println(empl2);
		
		Connection conn = null;
	}

}

class Emp{
	String fName;
	String lName;
	
	public Emp(String fn, String ln) {
		fName = fn; lName = ln;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	@Override
	public String toString() {
		return "Emp [fName=" + fName + ", lName=" + lName + "]";
	}
	
}