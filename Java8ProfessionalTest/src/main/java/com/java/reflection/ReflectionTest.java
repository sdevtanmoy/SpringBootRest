package com.java.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author tanmoydas
 *
 * 	Getting all the private field of an Object and putting it's value to into a map 
 *
 */
public class ReflectionTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		MyObject obj = new MyObject();

		Field[] fields = obj.getClass().getDeclaredFields();
		System.out.println("Start");
		for (Field f : fields) {
			System.out.println(f.getName() + " - " + f.getGenericType());
		}
		System.out.println("End");
		
		Map<String, Object> props = new ReflectionTest().mapper(obj);
		
		 /*com.fasterxml.jackson.databind.ObjectMapper mapper = new
		 com.fasterxml.jackson.databind.ObjectMapper(); Map<String, Object> props =
		 mapper.convertValue(obj, Map.class);*/
		 System.out.println(props.size()); 
		for (Map.Entry<String, Object> entry : props.entrySet()) {
			if (entry.getValue() instanceof String || entry.getValue() instanceof Integer
					|| entry.getValue() instanceof Double || entry.getValue() instanceof Character) {
				System.out.println(entry.getKey() + "-->" + entry.getValue());
			}
		}
		 
	}

	Map<String, Object> mapper(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Map<String, Object> props = new HashMap<>();

		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			props.put(f.getName(), f.get(obj));
		}

		return props;
	}
}

class MyObject {

	private String name;
	private Integer age;
	private Double salary;
	private char enabled;
	String pinCode;
	public String address;

	protected String houseNo;

	public MyObject(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public MyObject() {
		this.name = "Tanmoy";
		this.age = 30;
		this.salary = 12.5;
		this.address = "Krishnapur";
		this.houseNo = "AC-133";
		this.pinCode = "700102";
		this.enabled = 'A';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public char getEnabled() {
		return enabled;
	}

	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	
	

}