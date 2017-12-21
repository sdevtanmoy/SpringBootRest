package com.java.professional;

public class Program28 {

	public static void main(String[] args) {

		try (ImageScanner ir = new ImageScanner();
				ImagePrinter iw = new ImagePrinter()){
			
			ir.scanImage();
			iw.printImage();
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}

class ImageScanner implements AutoCloseable{

	@Override
	public void close() throws Exception {

		System.out.println("Scanner closed");
	}
	
	public void scanImage()throws Exception{
		System.out.println("Scan..");
		throw new Exception("Unable to scan");
	}
	
}

class ImagePrinter implements AutoCloseable{

	@Override
	public void close() throws Exception {

		System.out.println("Printer closed");
	}
	
	public void printImage()throws Exception{
		System.out.println("print..");
		throw new Exception("Unable to print");
	}
	
}
