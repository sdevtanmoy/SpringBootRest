package com.java.professional;

import java.util.Optional;

public class Program30 {

	public static void main(String[] args) {
		Address address = null;
		
		Optional<Address> addrs1 = Optional.ofNullable(address);
		
		Employee e1 = new Employee(addrs1);
		
		String eAddress = (addrs1.isPresent()) ? addrs1.get().getCity() : "City Not Available";
		
		System.out.println(eAddress);
	}
}

class Employee{
	Optional<Address> address;

	public Employee(Optional<Address> address) {
		this.address = address;
	}

	public Optional<Address> getAddress() {
		return address;
	}
	
}

class Address{
	String city = "New York";

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}
	
}