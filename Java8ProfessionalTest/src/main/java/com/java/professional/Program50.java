package com.java.professional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Program50 {

	public static void main(String[] args) {
		Stream<Path> paths = Stream.of(Paths.get("/Users/tanmoydas/Java-Work/ocpjp-test/Message.properties"),
				Paths.get("/Users/tanmoydas/Java-Work/ocpjp-test/courses.txt"));
		
		
		paths.filter(s-> s.toString().endsWith("txt")).forEach(s->{
					try {
						Files.readAllLines(s)
							.stream()
							.forEach(System.out::println);// n1
					}
					catch(IOException ioe) {
						System.err.println("excp"+ioe);
					}
				});
		
	}
}
