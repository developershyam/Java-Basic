package com.basic;
//mechanism in which one object acquires all the properties and behaviors of parent object.
//For Code Reusability.
//For Method Overriding (so runtime polymorphism can be achieved).


import java.util.Comparator;

import com.basic.dto.Child;
import com.basic.dto.Parent;

//On the basis of class, there can be three types of inheritance in java: single, multilevel and hierarchical.

// Multiple/Hybrid inheritance is not supported in java through class.
// Because To reduce the complexity and make simplify, without ambiguity
public class Inheritance {
	
	
	static  volatile int x =5;
	static final transient int y =5;
	public static void main(String[] args) {
		
		Parent p = new Child();
		System.out.println(p.getName());//Child
		
		Cls c = new Inheritance().new Cls();
		System.out.println("val: ");
		System.out.println("x: "+c.x);
		
		B b = new Inheritance().new Cls();
		System.out.println("val: ");
		System.out.println("x: "+b.x);
		
		
		
		
	}
	
	interface A{
		int x=1;
		//default int getVal(){ return 1;}
		static int getVal(){ return 1;}
		//int getVal();
	}
	interface B extends A{
		int x=2;
		static int getVal(){ return 2;}
		//default int getVal(){ return 2;}
		//int getVal();
	}
	
	interface C{
		//int x=3;
		static int getVal(){ return 3;}
		//default int getVal(){ return 3;}
		//int getVal();
	}
	
	class Cls implements B, C{
		int x=4;
		//public int getVal(){ return 4;}
	}
}

