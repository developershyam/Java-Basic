package com.basic;
//static keyword in java is used for memory management mainly.
//static keyword with variables, methods, blocks and nested class.

//The static variable can be used to refer the common property of all objects
//The static variable gets memory only once in class area at the time of class loading.
// static property is shared to all objects.
//A static method belongs to the class rather than object of a class.

////Call to super() must be the first statement in constructor.
import static java.lang.System.*;
public class StaticKeyword {

	static int x=10;
	
	public StaticKeyword(int val) {
		x=val;
	}
	
	public static void main(String[] args) {
		
		out.println("main method is staic");
		
		out.println("static x: "+StaticKeyword.x);
		
		StaticKeyword sk = new StaticKeyword(5);
		out.println("obj x: "+sk.x);
		out.println("static x: "+StaticKeyword.x);
		out.println("Static method getX: "+StaticKeyword.getX());
		
		A a = new A();
		B b = new StaticKeyword(0). new B();
	}
	
	static class A{
		
	}
	
    class B{
		
	}
	
	
	
	static {
		System.out.println("Static block");
	}
	
	static int getX() {
		return x;
	}
}
