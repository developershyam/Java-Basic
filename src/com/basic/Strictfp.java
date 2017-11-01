package com.basic;

//get the same result on every platform if you perform operations in the floating-point variable.

//strictfp keyword cannot be applied on abstract methods, variables or constructors.

public class Strictfp {

	strictfp class A {
	}// strictfp applied on class

	strictfp interface M {
	}// strictfp applied on interface

	class C {
		strictfp void m() {
		}// strictfp applied on method
	}
	
	strictfp class D {
		strictfp void m() {
		}// strictfp applied on method
	}
}
