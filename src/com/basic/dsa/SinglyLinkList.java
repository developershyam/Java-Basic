package com.basic.dsa;

import com.basic.dsa.CircularLinkedList.Node;

public class SinglyLinkList {

	Node head;

	public static void main(String[] args) {
		SinglyLinkList sl = new SinglyLinkList();

		sl.delete(5);
		sl.insert(5);
		sl.delete(5);

		sl.insert(10);

		sl.insert(15);
		sl.insert(30);
		sl.update(15, 20);

		sl.delete(20);

		sl.insert(70);

		sl.reverseIterative();
		sl.reverseRecursion(sl.head, null, null);
		
		Node node = sl.search(10);
		System.out.println("Node find for data: "+(node!=null? node.getData():null));
		System.out.println("Is circular: "+sl.isCircular(node));
		
		// System.out.println("Node:
		// "+(sl.search(30)!=null?sl.search(30).getData():null));

	}

	public void print(String operationMsg) {
		System.out.println();
		Node temp = head;
		System.out.println(operationMsg);
		while (temp != null) {
			System.out.print(" [" + temp.getData() + "] ");
			if (temp.next != null)
				System.out.print("-->");
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
				nextNode = currentNode.next;
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
				nextNode = currentNode.next;
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
			Node lastNode = head;
			Node parent = head;
			while (lastNode != null) {
				if (lastNode.getData() == data) {
					if (parent == head && head.next == null) {
						head = null;
					} else {
						parent.next = lastNode.next;
					}
					break;
				}
				parent = lastNode;
				lastNode = lastNode.next;
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
		}
		print("Insert " + data);
	}

	private boolean isCircular(Node node) {


		if(node==null) return true;
		
		int i=1;
		Node pointer1 = null;
		Node pointer2 = null;
		while(node.next!=null){
			
			pointer1 = node.next;
			if(i%2==0){
				pointer2 = node.next.next;
			}
			if(pointer1== pointer2){
				return true;
			}
			node = node.next;
			i++;
		}
		return false;
	}
	
	static class Node {
		int data;
		Node next;

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
	}
}
