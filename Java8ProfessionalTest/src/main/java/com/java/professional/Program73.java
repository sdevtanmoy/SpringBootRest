package com.java.professional;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Program73 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(4); // n1
		
		Future f1 = es.submit(new CallerThread("call"));
		String str = f1.get().toString();
		System.out.println(str);
	}
}

class CallerThread implements Callable<String>{
	String str;
	
	public CallerThread(String s) {this.str = s;}
	
	public String call()throws Exception{
		return str.concat(" callXX ");
	}
}