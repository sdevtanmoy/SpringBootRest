package com.java.professional;

import java.util.concurrent.atomic.AtomicInteger;

public class Program21 {

	public static void main(String[] args) {

		Thread t1 = new Thread(new MyThread());
		Thread t2 = new Thread(new MyThread());
		Thread t3 = new Thread(new MyThread());
		
		Thread [] tr = {t1, t2, t3};
		
		for(int x = 0; x< tr.length; x++) {
			tr[x].start();
		}
	}

}


class MyThread implements Runnable{
	
	private static AtomicInteger count = new AtomicInteger(0);
	
	public void run() {
		int x = count.incrementAndGet();
		System.out.println(x+" ");
	}
}