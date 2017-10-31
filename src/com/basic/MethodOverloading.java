package com.basic;

//If a class has multiple methods having same name but different in parameters
// 1. Type of args, 2. Number of args, 3. Order of args
//Method overloading increases the readability of the program.
//Method overloading is the example of compile time polymorphism.	
//applicable on same/one class.
//Method Overloading is not possible by changing the return type of the method only.
//Vararg and array both treated like same as array, so same syntax for both is ambiguity
//Type promotion is applied then, same rule is applied for all. i.e. suppose one is int to float then other must also otherwise ambiguity error.
public class MethodOverloading {

	public static void main(String[] args) {

		System.out.println(add(1, 2));
		System.out.println(add(1, 2, 3));
		System.out.println(add(1, 2, 3, 4));

		System.out.println(add(1, 2f));
		System.out.println(add(1f, 2));
		System.out.println(add(1f, 2f));
	}

	/*
	 * char add(int x, int y) { char c = ' '; return c; }
	 */

	public static int add(int x, int y) {
		System.out.print("1.1: ");
		return x + y;
	}

	public static int add(int x, int y, int z) {
		System.out.print("1.2: ");
		return x + y;
	}

	public static int add(int... x) { // Varag or array any one of them can be used
		System.out.print("1.3: ");
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		return sum;
	}

	public static float add(int x, float y) {
		System.out.print("2.1: ");
		return x + y;
	}

	public static float add(float x, int y) {
		System.out.print("2.2: ");
		return x + y;
	}

	public static float add(float x, float y) {
		System.out.print("2.3: ");
		return x + y;
	}

}
