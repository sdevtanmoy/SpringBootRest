package com.java.professional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Program32 {

	public static void main(String[] args) {
		
		List<Vehicle2> liVecs = new ArrayList<Vehicle2>();
		liVecs.add(new Vehicle2(10123, "Ford"));
		liVecs.add(new Vehicle2(10124, "BMW"));
		
		System.out.println(liVecs);
		Set<Vehicle2> vehicles = new TreeSet<>();
		vehicles.add(new Vehicle2(10123, "Ford"));
		vehicles.add(new Vehicle2(10124, "BMW"));
		// class cast exception
		System.out.println(vehicles);
		
		
	}
}

class Vehicle2{
	int vno;
	String name;
	public Vehicle2(int vno, String name) {
		this.vno = vno;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Vehicle [vno=" + vno + ", name=" + name + "]";
	}
	
	
}
