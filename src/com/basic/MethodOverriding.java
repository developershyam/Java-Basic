package com.basic;

import com.test.dto.Child;
import com.test.dto.Parent;

//If subclass (child class) has the same method as declared in the parent class, 
//Method overriding is used to provide specific implementation of a method that is already provided by its super class.
//	Method overriding is the example of run time polymorphism.
//applicable in parent-child relationship only

//Method overriding is used for runtime polymorphism

//method must have same name as in the parent class
//method must have same parameter as in the parent class.
//must be IS-A relationship (inheritance).

//Override method can not be more restrictive, compilation error
//Variables can not participate in Overriding
//static method cannot be overridden because static method is bound with class. Static belongs to class area

//Covariant Return Type: return type specifies that the return type may vary in the same direction as the subclass.

//private, static, and finally method can not be override

//ExceptionHandling with MethodOverriding in
//  1.	If the superclass method does not declare an exception, 
//		subclass overridden method cannot declare the checked exception but it can declare unchecked exception(RuntimeException).
//  2.	If the superclass method declares an exception,  
//		subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.
public class MethodOverriding {

	public static void main(String[] args) {

		// SBI s = new SBI();
		// ICICI i = new ICICI();
		// AXIS a = new AXIS();
		// System.out.println("SBI Rate of Interest: " + s.getRateOfInterest());
		// System.out.println("ICICI Rate of Interest: " + i.getRateOfInterest());
		// System.out.println("AXIS Rate of Interest: " + a.getRateOfInterest());

		Parent p = new Parent();
		Child c = new Child();
		Parent pc = new Child();

		System.out.println(p.getName());// Parent
		System.out.println(p.name);// Parent
		System.out.println(p.testStatic());// Parent: testStatic

		System.out.println(c.getName());// Child
		System.out.println(c.name);// Child
		System.out.println(c.testStatic());// Child: testStatic

		// Overriding Test

		System.out.println(pc.getName()); // Child :: Overriding
		System.out.println(pc.name);// Parent :: Not Overriding

		System.out.println(pc.testStatic());// Parent: testStatic :: Not Overriding

		System.out.println(pc.testCovariant());// com.test.Child@xxxx :: Overriding
	}
}


