package com.basic;
//reference variable that refers to the current object.

// can be used for current instance, access variable, call method, constructor.

//Call to this() must be the first statement in constructor.

public class ThisKeyword {

	int x;
	public ThisKeyword() {
		System.out.println("no args-const");
	}
	
	public ThisKeyword(int x) {
		this();
		this.x =x;
		System.out.println("one args-const");
	}
	
	public int getX() {
		return x;
	}
	
	public static void main(String[] args) {
		
		
		
		ThisKeyword tk = new ThisKeyword(10);
		System.out.println("x: "+tk.x);
		System.out.println("x: "+tk.getX());
	}
}
