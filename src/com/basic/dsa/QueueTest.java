package com.basic.dsa;

import java.util.Arrays;

public class QueueTest {

	int queueArr[];
	int queueSize;
	int front, rear, noOfItmes;

	public QueueTest(int size) {
		queueSize = size;
		queueArr = new int[queueSize];
		Arrays.fill(queueArr, -1);
	}

	private void insert(int item) {
		if (noOfItmes < queueSize) {
			if (rear >= queueSize)
				rear = 0;

			queueArr[rear] = item;
			noOfItmes++;
			rear++;
			print();

		} else {
			System.out.println("Queue overflow....");
		}
	}

	private void priorityInsert(int item) {
		int i;
		if (noOfItmes == 0) {
			insert(item);
		}else if(noOfItmes < queueSize) {
			if (rear >= queueSize)
				rear = 0;
			for (i = noOfItmes - 1; i >= 0; i--) {

				if (item > queueArr[i]) {
					queueArr[i + 1] = queueArr[i];
				} else
					break;
			}
			queueArr[i+1] = item;
			rear++;
			noOfItmes++;
			print();
		}else{
			System.out.println("Queue overflow....");
		}
	}
	
	private void remove() {
		if (noOfItmes > 0) {
			if (front >= queueSize)
				front = 0;
			int item = queueArr[front];
			queueArr[front] = -1;
			noOfItmes--;
			front++;
			print();
		} else {
			System.out.println("Queue underflow....");
		}
	}

	private void print() {

		System.out.println();
		for (int item : queueArr) {
			System.out.print("-----");
		}
		System.out.println();

		for (int i = 0; i < queueSize; i++) {
			System.out.print(" | " + (queueArr[i] != -1 ? queueArr[i] : "  "));
			if (i == queueSize - 1)
				System.out.print(" |END");
		}
		System.out.println();
		for (int item : queueArr) {
			System.out.print("-----");
		}
		System.out.println();
		for (int i = 0; i < queueSize; i++) {
			boolean match = false;
			System.out.print("   ");
			if (front == i) {
				System.out.print("F");
				match = true;
			}
			if (rear == i) {
				System.out.print("R");
				match = true;
			}
			if (!match)
				System.out.print("  ");
		}
		if (rear == queueSize)
			System.out.print("R");
		if (front == queueSize)
			System.out.print("F");

		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {

		QueueTest queue = new QueueTest(9);
		queue.remove();
		
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		queue.insert(4);
		queue.insert(5);
		queue.insert(6);
		queue.insert(7);
		queue.insert(8);
		queue.insert(9);
		queue.insert(10);

		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		
		queue.insert(8);
		queue.insert(9);
		queue.insert(10);
		queue.remove();
		queue.remove();
		queue.remove();

		QueueTest pQueue = new QueueTest(7);
		System.out.println("Priority Queue");
		pQueue.priorityInsert(1);
		pQueue.priorityInsert(3);
		pQueue.priorityInsert(5);
		pQueue.priorityInsert(2);
		pQueue.priorityInsert(4);
		pQueue.priorityInsert(6);
		pQueue.priorityInsert(7);
		pQueue.priorityInsert(9);
		pQueue.priorityInsert(10);

		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();
		pQueue.remove();

	}

}
