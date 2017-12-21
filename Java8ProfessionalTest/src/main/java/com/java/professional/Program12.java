package com.java.professional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Program12 {

	public static void main(String[] args) throws IOException {
		
		Path file = Paths.get("/Users/tanmoydas/Java-Work/courses.txt");
		//1. it is failing
		//List<String> fc = (List<String>) Files.lines(file);
		//fc.stream().forEach(s -> System.out.print(s));
		
		//2.  excp
		//Stream<String> fc = (Stream<String>) Files.readAllLines(file);
		//fc.forEach(s -> System.out.print(s));
		
		// 3. ok
		List<String> fc = Files.readAllLines(file);
		fc.stream().forEach(s -> System.out.print(s));
		
		//4. ok
		@SuppressWarnings("resource")
		Stream<String> fcs = Files.lines(file);
		fcs.forEach(s-> System.out.println(s));
	}
}
