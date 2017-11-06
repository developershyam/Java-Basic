package com.basic.thread;

import java.util.LinkedList;

public class ProducerConsumerWaitNotify {

	LinkedList<Integer> buffer = new LinkedList<>();
	int capacity = 3;
	int value = 1;

	public static void main(String[] args) throws InterruptedException {

		final ProducerConsumerWaitNotify pc = new ProducerConsumerWaitNotify();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.produce("Producer-1");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.consume("Consumer-1");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}

	public void produce(String name) throws InterruptedException {

		synchronized (this) {

			while (true) {

				if (buffer.size() == capacity) {
					System.out.println("Buffer is full ... can not add more");
					wait();
				}

				buffer.add(value);
				System.out.println(name+ " Produced: " + value);
				value++;

				notify();

				Thread.sleep(1000);
			}
		}
	}

	public void consume(String name) throws InterruptedException {

		synchronized (this) {

			while (true) {

				if (buffer.size() == 0) {
					System.out.println("Buffer is empty ... can not read");
					wait();
				}

				int value = buffer.removeFirst();
				System.out.println(name+ " Consumed: " + value);

				notify();

				Thread.sleep(1000);
			}
		}
	}

}
