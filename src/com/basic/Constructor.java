package com.basic;

import com.basic.dto.Child;
import com.basic.dto.Parent;

//special type of method that is used to initialize the object.
//constructor is invoked at the time of object creation.
//Constructor name must be same as its class name
//Constructor must have no explicit return type
//	1.	Default constructor (no-arg constructor)
//	2.	Parameterized constructor

//Constructor Overloading possible, Overriding not
//Constructor must not have return type.
//The java compiler provides a default constructor if you don't have any constructor.
//Constructor is invoked implicitly.

public class Constructor {

	public static void main(String[] args) {

		Parent p1 = new Child();//Parent: no-args	//Child: no-args
		System.out.println("*****************");
		
		Parent p2 = new Child(1);//Parent: one-args => 1	//Child: one-args => 1
		System.out.println("*****************");
		
		Parent p3 = new Child(1, 2);//Parent: no-args	//Child: two -args => 1, 2
		System.out.println("*****************");
		
		Parent p4 = new Child(1, 2, 3);//Parent: no-args	//Child: two -args => 1, 2
		System.out.println("*****************");
		

	}
	

}
