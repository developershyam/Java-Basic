package com.basic;
//mechanism in which one object acquires all the properties and behaviors of parent object.
//For Code Reusability.
//For Method Overriding (so runtime polymorphism can be achieved).


import com.basic.dto.Child;
import com.basic.dto.Parent;

//On the basis of class, there can be three types of inheritance in java: single, multilevel and hierarchical.

// Multiple/Hybrid inheritance is not supported in java through class.
// Because To reduce the complexity and make simplify, without ambiguity
public class Inheritance {
	
	public static void main(String[] args) {
		
		Parent p = new Child();
		System.out.println(p.getName());//Child
		
	}

}

