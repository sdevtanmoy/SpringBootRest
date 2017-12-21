package com.java.professional;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class Program69 {

	public static void main(String[] args) {
		UnaryOperator<Double> uo1 = s->s*2;
		
		List<Double> loanValues = Arrays.asList(1000.0, 1500.0, 2000.0);
		
		loanValues.stream()
			.filter(lv ->lv>=1500)
			.map(lv->uo1.apply(lv))
			.forEach(s->System.out.print(s+" "));
	}
}
