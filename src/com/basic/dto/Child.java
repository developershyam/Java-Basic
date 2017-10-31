package com.basic.dto;

import java.io.IOException;

public class Child extends Parent {

	public Child() {
		System.out.println("Child: no-args");
	}
	
	public Child(int x) {
		super(x);
		System.out.println("Child: one-args => "+x);
	}
	
	public Child(int x, int y) {
		System.out.println("Child: two -args => "+x+", "+y);
	}
	
	public Child(int x, int y, int z) {
		this(x, y);
		System.out.println("Child: three -args => "+x+", "+y);
	}
	
	//Constructor can throw parent exception, in method not allowed
	public Child(String s) throws Exception{
		super(s);
		System.out.println("Parent: one-args-String throws Ex. => "+s);
	}
	
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
