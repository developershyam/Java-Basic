package com.test.dto;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Parent {

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