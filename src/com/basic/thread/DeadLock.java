package com.basic.thread;

public class DeadLock {
	
	String str1 = "1";
	String str2 = "2";
	public static void main(String[] args) throws Exception{
		
		final DeadLock deadLock = new DeadLock();
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true){
					synchronized (deadLock.str1) {
						
						System.out.println("In Thread 1 - synchronized (deadLock.str1)");
						synchronized (deadLock.str2) {
							
							System.out.println("In Thread 1 - synchronized (deadLock.str2)");
						}
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true){
					synchronized (deadLock.str2) {
						
						System.out.println("In Thread 2 - synchronized (deadLock.str2)");
						synchronized (deadLock.str1) {
							
							System.out.println("In Thread 2 - synchronized (deadLock.str1)");
						}
					}
				}
			}
		});
		
		t1.start();
		t2.start();
	}

}
