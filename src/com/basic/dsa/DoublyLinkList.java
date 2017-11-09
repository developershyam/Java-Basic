package com.basic.dsa;

public class DoublyLinkList {

	Node head;

	public static void main(String[] args) {
		DoublyLinkList sl = new DoublyLinkList();

		sl.delete(5);
		sl.insert(5);
		sl.reverseIterative();
		sl.delete(5);

		sl.insert(10);
		sl.insert(15);
		sl.reverseIterative();
		sl.insert(30);
		sl.insert(40);
		sl.update(15, 20);

		sl.delete(20);
		// System.out.println("Node:
		// "+(sl.search(30)!=null?sl.search(30).getData():null));
		sl.reverseIterative();
		sl.reverseRecursion(sl.head, null, null);

	}

	public void print(String operationMsg) {
		System.out.println();
		Node temp = head;
		System.out.println(operationMsg);
		while (temp != null) {

			if (temp.prev != null && temp.prev.next != null)
				System.out.print("<==>");

			System.out.print(" [" + temp.getData() + "] ");

			temp = temp.next;
		}
		if (head == null)
			System.out.println("Empty list.........");
		else
			System.out.println();
	}

	private void reverseIterative() {

		if (head != null) {

			Node currentNode = head;
			Node prevNode = null;
			Node nextNode = null;
			while (currentNode != null) {
				prevNode = currentNode.prev;
				nextNode = currentNode.next;

				currentNode.prev = currentNode.next;
				currentNode.next = prevNode;

				prevNode = currentNode;
				currentNode = nextNode;

			}
			head = prevNode;

		}
		print("Reversed Iterative");
	}

	public void reverseRecursion(Node currentNode, Node nextNode, Node prevNode) {
		if (head != null) {
			if (currentNode != null) {

				prevNode = currentNode.prev;
				nextNode = currentNode.next;

				currentNode.prev = currentNode.next;
				currentNode.next = prevNode;

				prevNode = currentNode;
				currentNode = nextNode;
				reverseRecursion(currentNode, nextNode, prevNode);
			} else {
				head = prevNode;
				print("Reversed Recursion");
			}
		}
	}

	public void delete(int data) {

		if (head != null) {
			Node currentNode = head;
			Node parent = head;
			while (currentNode != null) {
				if (currentNode.getData() == data) {
					if (parent == head && head.next == null) {
						head = null;
					} else if (parent == head) {
						head = currentNode.next;
						head.prev = null;
					} else {
						parent.next = currentNode.next;
						currentNode.next.prev = currentNode.prev;
					}
					break;
				}
				parent = currentNode;
				currentNode = currentNode.next;
			}
		}
		print("Delete " + data);
	}

	public void update(int oldVal, int newVal) {

		if (head != null) {
			Node lastNode = head;
			while (lastNode != null) {
				if (lastNode.getData() == oldVal) {
					lastNode.setData(newVal);
					break;
				}
				lastNode = lastNode.next;
			}
		}
		print("Update " + oldVal + " to " + newVal);
	}

	public Node search(int data) {

		Node temp = head;
		if (temp != null) {
			while (temp != null) {
				if (temp.getData() == data) {
					return temp;
				}
				temp = temp.next;
			}
		}
		return null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node lastNode = head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
			newNode.prev = lastNode;
		}
		print("Insert " + data);
	}

	static class Node {
		int data;
		Node next;
		Node prev;

		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}
	}
}
