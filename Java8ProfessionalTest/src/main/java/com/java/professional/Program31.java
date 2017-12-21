package com.java.professional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;


public class Program31 {

	public static void main(String[] args) throws IOException {
		Stream<Path> files = Files.walk(Paths.get(System.getProperty("user.home")));
		
		files.forEach( fName -> { // n1
			try {
				Path aPath = fName.toAbsolutePath(); // n2
				System.out.println(fName+":" 
				+Files.readAttributes(aPath, BasicFileAttributes.class).creationTime());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
