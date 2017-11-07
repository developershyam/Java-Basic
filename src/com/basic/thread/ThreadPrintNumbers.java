package com.basic.thread;

public class ThreadPrintNumbers {

	int count = 1;
	int max = 20;

	public static void main(String[] args) throws InterruptedException{

		printNaturalNumbers1();
		Thread.sleep(3000);
		printNaturalNumbers2();
	}

	public static void printNaturalNumbers1() throws InterruptedException{

		ThreadPrintNumbers threadPrintNumbers = new ThreadPrintNumbers();
		Printer printer = threadPrintNumbers.new Printer();
		Thread evenThread = new Thread(threadPrintNumbers.new EvenOddThread("EVEN", printer));
		Thread oddThread = new Thread(threadPrintNumbers.new EvenOddThread("ODD", printer));

		evenThread.start();
		oddThread.start();
		
		evenThread.join();
		oddThread.join();
		
		System.out.println("\n !Done ");

	}

	class Printer {

		int count = 1;
		int max = 20;
		
		private int printEven(int number){
			System.out.print(number + (number<max?", ":""));
			return ++number;
		}
		
		private int printOdd(int number){
			System.out.print(number + (number<max?", ":""));
			return ++number;
		}
	}

	class EvenOddThread implements Runnable {

		String name;
		Printer printer;

		public EvenOddThread(String name, Printer printer) {
			this.name = name;
			this.printer = printer;
		}

		@Override
		public void run() {

			synchronized (printer) {
				try {
					while (printer.count <= printer.max) {
						
						if(count%2==0){
							printer.count=printer.printEven(printer.count);
						}else{
							printer.count=printer.printOdd(printer.count);
						}
						printer.notify();
						printer.wait();
						Thread.sleep(100);
					}
					printer.notifyAll();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void printNaturalNumbers2() throws InterruptedException{

		final ThreadPrintNumbers threadPrintNumbers = new ThreadPrintNumbers();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (threadPrintNumbers) {
					try {
						while (threadPrintNumbers.count <= threadPrintNumbers.max) {
							System.out.print((threadPrintNumbers.count++) + (threadPrintNumbers.count<threadPrintNumbers.max+1?", ":""));
							if (threadPrintNumbers.count % 2 == 0) {
								threadPrintNumbers.notify();
								threadPrintNumbers.wait();
							}
							Thread.sleep(100);
						}
						threadPrintNumbers.notifyAll();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (threadPrintNumbers) {
					try {
						while (threadPrintNumbers.count <= threadPrintNumbers.max) {
							System.out.print((threadPrintNumbers.count++) + (threadPrintNumbers.count<threadPrintNumbers.max?", ":""));
							if (threadPrintNumbers.count % 2 != 0) {
								threadPrintNumbers.notify();
								threadPrintNumbers.wait();
							}
							Thread.sleep(100);
						}
						threadPrintNumbers.notifyAll();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("\n !Done ");
	}

}
