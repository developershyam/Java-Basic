package com.test;
//Java Switch Statement is fall-through,  
//it executes all statement after first match if break statement is not used with switch cases.
// Constant/final in case clause.
public class SwitchExample {

	public static void main(String[] args) {
		int number = 20;
		final int TEN = 10;
		switch (number) {
		case TEN:
			System.out.println("10");
			break;
		case 20:
			System.out.println("20");
			break;
		case 30:
			System.out.println("30");
			break;
		default:
			System.out.println("Not in 10, 20 or 30");
		}
		String str1 = "s1";
		final String S1 = "s1";
		switch (str1) {
		case S1:
			System.out.println("S1");
			break;
		case "s2":
			System.out.println("S2");
			break;
		default:
			System.out.println("Not in S1, S2");
		}
	}
}
