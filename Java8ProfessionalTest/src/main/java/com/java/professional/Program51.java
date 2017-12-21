package com.java.professional;

import org.assertj.core.api.AutoCloseableBDDSoftAssertions;

public class Program51 {

	public static void main(String[] args){
		try(Folder f = new Folder()){
			f.open();
		}
	}
}

final class Folder implements AutoCloseable{    // n1
	//n2
	public void open() {
		System.out.println("open");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
}

