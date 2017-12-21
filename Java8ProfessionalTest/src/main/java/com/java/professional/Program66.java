package com.java.professional;

import java.time.LocalDate;
import java.time.Month;

public class Program66 {

	public static void main(String[] args) {
		LocalDate valentineDay = LocalDate.of(2015, Month.FEBRUARY, 14);
		System.out.println(valentineDay);
		
		LocalDate nextYear = valentineDay.plusYears(1);
		System.out.println(nextYear);
		LocalDate nextYear1 = nextYear.plusDays(15);
		System.out.println(nextYear1);
	}
}
