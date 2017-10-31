package com.test.dto;

import java.io.IOException;

public class Child extends Parent {

	public String name = "Child";

	public String getName() {
		return name;
	}

	public static String testStatic() {
		return "Child: testStatic";
	}

	public Child testCovariant() {
		return this;
	}

	public void testNoException() {
		System.out.println("Parent: testNoException");
	}

	public void testSameException() throws IOException {
		System.out.println("Parent: testSameException");
	}

	public void testChildException() throws RuntimeException {
		System.out.println("Parent: testChildException");
	}

}
