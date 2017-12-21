package com.java.professional;

import java.io.File;
import java.io.IOException;

public class Program13 {

	public static void main(String[] args) throws IOException{
		
		new Program13().recDelete("/Users/tanmoydas/Java-Work/java8Test/");
	}
	
	public void recDelete(String dirName) throws IOException {
		File[] listOfFiles = new File(dirName).listFiles();
		
		if(listOfFiles != null && listOfFiles.length >0) {
			for(File aFile: listOfFiles) {
				System.err.println(aFile.getAbsolutePath()+ "-- is dir "+aFile.isDirectory());
				if(aFile.isDirectory()) {
					recDelete(aFile.getAbsolutePath());
				}else {
					if(aFile.getName().endsWith(".class")) {
						aFile.delete();
					}
				}
			}
		}
	}
}
