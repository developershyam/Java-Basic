package com.basic;

public class TestThreadTwice1 implements Runnable{

	Thread t;
	public TestThreadTwice1() {
		t = new Thread(this);
	}
	public void run() {
		System.out.println("running...");
	}

	public static void main(String args[]) throws InterruptedException{
		TestThreadTwice1 t1 = new TestThreadTwice1();
		t1.t.start();
		
		Thread.sleep(1000);
		t1.t.start();
	}
}
