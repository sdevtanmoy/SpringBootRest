/**
 * 
 */
package com.java.professional;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * @author tanmoydas
 *
 */
public class Program2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IntStream stream = IntStream.of(1, 2, 3);
		IntFunction<IntUnaryOperator> intFu = x->y->x*y; // n1
		
		IntStream newStream = stream.map(intFu.apply(10)); //n2
		
		newStream.forEach(System.out::println);
	}

}
