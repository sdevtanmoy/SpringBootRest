package com.java.professional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Program77 {

	public static void main(String[] args) throws IOException {
		Path source = Paths.get("/Users/tanmoydas/Java-Work/ocpjp-test/courses.txt");
		
		Path target = Paths.get("/Users/tanmoydas/Java-Work/ocpjp-test");
		
		//Files.move(source, target, StandardCopyOption.ATOMIC_MOVE);
		//Files.delete(source);
		Files.copy(source, target);
	}
}
