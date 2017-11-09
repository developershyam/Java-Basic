package com.basic.dsa;

public class QueueStaticImpl {

	private int capacity;
	int queueArr[];
	int front = -1;
	int rear = 0;
	int currentSize = 0;

	public QueueStaticImpl(int queueSize) {
		this.capacity = queueSize;
		queueArr = new int[this.capacity];
	}

	/**
	 * this method adds element at the end of the queue.
	 * 
	 * @param item
	 */
	public void enqueue(int item) {
		if (isQueueFull()) {
			System.out.println("Overflow ! Unable to add element: " + item);
		} else {
			front++;
			queueArr[front] = item;
			System.out.println("Element " + item + " is pushed to Queue !");
			printQueue();
		}
	}

	/**
	 * this method removes an element from the top of the queue
	 */
	public void dequeue() {
		if (isQueueEmpty()) {
			System.out.println("Underflow ! Unable to remove element from Queue");
		} else {
			rear++;
			System.out.println("Pop operation done !");
			printQueue();
		}
	}

	/**
	 * This method checks whether the queue is full or not
	 * 
	 * @return boolean
	 */
	public boolean isQueueFull() {
		boolean status = false;
		if (front >= capacity - 1) {
			status = true;
		}
		return status;
	}

	/**
	 * This method checks whether the queue is empty or not
	 * 
	 * @return
	 */
	public boolean isQueueEmpty() {
		boolean status = false;
		if (front < rear) {
			status = true;
		}
		return status;
	}

	/**
	 * This method print queue
	 * 
	 * @return
	 */
	public void printQueue() {
		if (front >= rear) {
			for (int i = rear; i <= front; i++) {
				System.out.print(queueArr[i] + (i < front ? ", " : ""));
			}
		}
		System.out.println();
	}

	public static void main(String a[]) {

		QueueStaticImpl queue = new QueueStaticImpl(4);

		queue.dequeue();
		queue.enqueue(23);
		queue.enqueue(2);
		queue.enqueue(73);
		queue.enqueue(21);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}

}
// Output
// Underflow ! Unable to remove element from Queue
// Element 23 is pushed to Queue !
// 23
// Element 2 is pushed to Queue !
// 23, 2
// Element 73 is pushed to Queue !
// 23, 2, 73
// Element 21 is pushed to Queue !
// 23, 2, 73, 21
// Pop operation done !
// 2, 73, 21
// Pop operation done !
// 73, 21
// Pop operation done !
// 21
// Pop operation done !