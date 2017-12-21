package com.java.professional;

import java.util.function.BiFunction;

public class Program67 {

	public static void main(String[] args) {
		
		BiFunction<Integer, Double, Double> val = (t1, t2) -> t1+t2; // n1
		
		System.out.println(val.apply(10, 10.5));
	}
}
