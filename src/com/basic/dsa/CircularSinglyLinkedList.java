package com.basic.dsa;

public class CircularSinglyLinkedList {

	public int size = 0;
	public Node head = null;
	public Node tail = null;

	// add a new node at the start of the linked list
	public void addNodeAtStart(int data) {
		System.out.println("Adding node " + data + " at start");
		Node n = new Node(data);
		if (size == 0) {
			head = n;
			tail = n;
			n.next = head;
		} else {
			Node temp = head;
			n.next = temp;
			head = n;
			tail.next = head;
		}
		size++;
		print();
	}

	public void addNodeAtEnd(int data) {
		if (size == 0) {
			addNodeAtStart(data);
		} else {
			Node n = new Node(data);
			tail.next = n;
			tail = n;
			tail.next = head;
			size++;
		}
		System.out.println("\nNode " + data + " is added at the end of the list");
		print();
	}

	public void deleteNodeFromStart() {
		if (size == 0) {
			System.out.println("\nList is Empty");
		} else {
			System.out.println("\ndeleting node " + head.data + " from start");
			head = head.next;
			tail.next = head;
			size--;
		}
		print();
	}

	public int elementAt(int index) {
		if (index > size) {
			return -1;
		}
		Node n = head;
		while (index - 1 != 0) {
			n = n.next;
			index--;
		}
		return n.data;
	}
	
	public Node element(int data) {
		if (size<0) {
			return null;
		}
		Node n = head;
		while (n != null) {
			if(n.data == data){
				return n;
			}else if(n.next == head){
				break;
			}else{
				n = n.next;
			}
			
		}
		return null;
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

	// print the linked list
	public void print() {
		System.out.print("Circular Linked List:");
		Node temp = head;
		if (size <= 0) {
			System.out.print("List is empty");
		} else {
			do {
				System.out.print(" [" + temp.data + "] ");
				if (temp != tail)
					System.out.print("-->");
				temp = temp.next;
			} while (temp != head);
		}
		System.out.println();
		System.out.println();
	}

	// get Size
	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		CircularSinglyLinkedList c = new CircularSinglyLinkedList();
		c.addNodeAtStart(3);
		c.addNodeAtStart(2);
		c.addNodeAtStart(1);
		c.deleteNodeFromStart();
		c.addNodeAtEnd(4);
		
		Node node = c.element(3);
		System.out.println("Node find for data: " + node.data);
		System.out.println("Is Circular: "+c.isCircular(node));
		
		System.out.println();
		System.out.println("Size of linked list: " + c.getSize());
		System.out.println("Element at 2nd position: " + c.elementAt(2));
	}

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

}
