package com.java.professional;

import java.util.concurrent.CyclicBarrier;

public class Program57 {

	public static void main(String[] args) {
		
		Master master = new Master();
		//n2
		CyclicBarrier cb = new CyclicBarrier(1, master);
		Worker worker = new Worker(cb);
		worker.start();
	}
}


class Worker extends Thread{
	
	CyclicBarrier cb;
	
	public Worker(CyclicBarrier cb) {this.cb = cb;}
	
	public void run() {
		try {
			cb.await();
			System.out.println("Worker..");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class Master implements Runnable{ // n1

	@Override
	public void run() {

		System.out.println("Master....");
	}
	
}