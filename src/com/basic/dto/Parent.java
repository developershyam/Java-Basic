package com.basic.dto;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Parent {
	
	public Parent() {
		System.out.println("Parent: no-args");
	}
	
	public Parent(int x) {
		System.out.println("Parent: one-args => "+x);
	}
	
	public Parent(String s) throws IOException{
		System.out.println("Parent: one-args-String throws Ex. => "+s);
	}

	public String name = "Parent";

	public String getName() {
		return name;
	}

	public  static String testStatic() {
		return "Parent: testStatic";
	}

	public Parent testCovariant() {
		return this;
	}

	public void testNoException() throws FileNotFoundException {
		System.out.println("Parent: testNoException");
	}

	void testSameException() throws IOException {
		System.out.println("Parent: testSameException");
	}

	public void testChildException() throws Exception {
		System.out.println("Parent: testChildException");
	}

}